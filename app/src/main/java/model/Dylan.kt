package model

import android.app.AlertDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toDrawable
import com.example.view.DrawingView
import com.example.view.GameActivity
import com.example.view.R
import java.util.concurrent.TimeUnit


class Dylan (override var position : Position) : Character(position) {

    override fun draw(canvas: Canvas?, drawingView: DrawingView) {
        val paint = Paint()

        val img = BitmapFactory.decodeResource(drawingView.resources, R.drawable.dylan)

        val x: Float = position.convertPositionToScreen()[0]
        val y: Float = position.convertPositionToScreen()[1]
        val resized = Bitmap.createScaledBitmap(img, 190, 220, true)
        paint.isFilterBitmap = true;
        paint.isDither = true;
        canvas?.drawBitmap(resized, x.toFloat(), y.toFloat(), paint)

    }

    private fun getOppositeDirection(direction: Direction?): Direction? {
        return when (direction) {
            Direction.DOWN -> Direction.UP
            Direction.LEFT -> Direction.RIGHT
            Direction.UP -> Direction.DOWN
            Direction.RIGHT -> Direction.LEFT
            else -> return null
        }
    }

    override fun move(direction: Direction, drawingView: DrawingView, gameActivity: GameActivity) {

        // Computing the desired position and checking the outcome
        var nextPosition: Position = when (direction) {
            Direction.UP -> Position(position.x, position.y - 1)
            Direction.DOWN -> Position(position.x, position.y + 1)
            Direction.LEFT -> Position(position.x - 1, position.y)
            Direction.RIGHT -> Position(position.x + 1, position.y)
        }

        var currentSquare: Square? =
            Game.levels[Game.selectedLevel].board.getSquareFromPosition(position)
        var nextSquare: Square? =
            Game.levels[Game.selectedLevel].board.getSquareFromPosition(nextPosition)

        Log.d("Dylan", (nextSquare?.obstacle?.direction != direction).toString())
        Log.d(
            "Dylan",
            (getOppositeDirection(nextSquare?.obstacle?.direction) != direction).toString()
        )
        Log.d("Dylan", position.y.toString())
        Log.d("Dylan", nextPosition.y.toString())
        var i = 0

        if (currentSquare?.obstacle?.direction == direction &&
            getOppositeDirection(nextSquare?.obstacle?.direction) == direction
        ) {
            val vibrator =
                gameActivity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        200,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                vibrator.vibrate(200)
            }
        } else {
            // There is a direction where user wants to go
            while (currentSquare?.obstacle?.direction != direction &&
                getOppositeDirection(nextSquare?.obstacle?.direction) != direction && currentSquare?.squareType != SquareType.TARGET && currentSquare != null
            ) {

                // Computing the desired position and checking the outcome
                Log.d("Dylan", "While")
                Log.d("Dylan", position.y.toString())
                Log.d("Dylan", nextPosition.y.toString())
                var otherCharacterOnNextPosition = false

                // The obstacle on which is on the same square as the user is in a different direction as the direction where the user wants to go
                // Check if there is someone at next position
                for (character in Game.levels[Game.selectedLevel].characters) {
                    if (character.position == nextPosition) {
                        otherCharacterOnNextPosition = true
                    }
                }

                if (nextSquare == null) {
                    // Showing dead message and putting the character in -1, -1 so it is invisible
                    val builder = AlertDialog.Builder(gameActivity)
                    builder.setMessage(R.string.dialog_character_fallen_message)
                        .setTitle(R.string.dialog_character_fallen_title).show();
                    this.position = Position(-1, -1)
                }
                Log.d("Dylan", otherCharacterOnNextPosition.toString())
                if (!otherCharacterOnNextPosition) {
                    // User can move!
                    this.position = nextPosition // Updating position
                    nextSquare?.actionOnSquare(this) // Action on square
                } else {
                    // User hurt a character, phones vibrates and user does not move
                    val vibrator =
                        gameActivity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(
                            VibrationEffect.createOneShot(
                                200,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    } else {
                        vibrator.vibrate(200)
                    }
                }

                nextPosition = when (direction) {
                    Direction.UP -> Position(position.x, position.y - 1)
                    Direction.DOWN -> Position(position.x, position.y + 1)
                    Direction.LEFT -> Position(position.x - 1, position.y)
                    Direction.RIGHT -> Position(position.x + 1, position.y)
                    Direction.RIGHT -> Position(position.x + 1, position.y)
                }
                currentSquare =
                    Game.levels[Game.selectedLevel].board.getSquareFromPosition(position)
                nextSquare =
                    Game.levels[Game.selectedLevel].board.getSquareFromPosition(nextPosition)


            }
            drawingView.invalidate()

        }
    }
}