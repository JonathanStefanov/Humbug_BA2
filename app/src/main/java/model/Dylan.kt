package model

import android.app.AlertDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import com.example.view.DrawingView
import com.example.view.GameActivity
import com.example.view.R


class Dylan (override var position : Array<Int>) : Character(position) {

    override fun drawCharacter(canvas: Canvas?, drawingView: DrawingView) {
        val paint = Paint()

        val img = BitmapFactory.decodeResource(drawingView.resources, R.drawable.dylan)

        val x: Float = this.convertPositionToScreen(position)[0]
        val y: Float = this.convertPositionToScreen(position)[1]
        val resized = Bitmap.createScaledBitmap(img, 190, 220, true)
        paint.isFilterBitmap = true;
        paint.isDither = true;
        canvas?.drawBitmap(resized, x.toFloat(), y.toFloat(), paint)

    }


    override fun move(
        direction: Direction,
        level: Level
    ): Boolean {
        var canMove = false

        // Computing the desired position and checking the outcome
        var nextPosition: Array<Int> = when (direction) {
            Direction.UP -> arrayOf(position[0], position[1] - 1)
            Direction.DOWN -> arrayOf(position[0], position[1]  + 1)
            Direction.LEFT -> arrayOf(position[0] - 1, position[1])
            Direction.RIGHT -> arrayOf(position[0] + 1, position[1] )
        }
        var currentSquare: Square? =
            level.getSquareFromPosition(position)
        var nextSquare: Square? =
            level.getSquareFromPosition(nextPosition)


        if (currentSquare?.obstacle?.direction == direction &&
            getOppositeDirection(nextSquare?.obstacle?.direction) == direction
        ) {
            // User hurt a wall, phones vibrates and user does not move
            canMove = true
        } else {
            // There is a direction where user wants to go
            while (currentSquare?.obstacle?.direction != direction &&
                getOppositeDirection(nextSquare?.obstacle?.direction) != direction && currentSquare?.squareType != SquareType.TARGET && currentSquare != null
            ) {
                // Computing the desired position and checking the outcome

                var otherCharacterOnNextPosition = false

                // The obstacle on which is on the same square as the user is in a different direction as the direction where the user wants to go
                // Check if there is someone at next position
                for (character in level.characters) {
                    if (character.position[0] == nextPosition[0] && character.position[1] == nextPosition[1]) {
                        otherCharacterOnNextPosition = true
                    }
                }

                if (nextSquare == null) {
                    // Showing dead message and putting the character in -1, -1 so it is invisible
                    canMove = true
                    this.position = arrayOf(-1, -1)
                } else if (!otherCharacterOnNextPosition) {
                    // User can move!
                    canMove = true
                    this.position = nextPosition // Updating position
                    nextSquare?.actionOnSquare(this, level) // Action on square
                } else {
                    // User hurt a character or wall, phones vibrates and user does not move
                    canMove = false
                }

                nextPosition = when (direction) {
                    Direction.UP -> arrayOf(position[0], position[1] - 1)
                    Direction.DOWN -> arrayOf(position[0], position[1]  + 1)
                    Direction.LEFT -> arrayOf(position[0] - 1, position[1])
                    Direction.RIGHT -> arrayOf(position[0] + 1, position[1] )
                }

                currentSquare =
                    level.getSquareFromPosition(position)

                nextSquare =
                    level.getSquareFromPosition(nextPosition)
            }
            

        }
    return canMove
    }

}