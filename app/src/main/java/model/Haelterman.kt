package model

import android.app.AlertDialog
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.view.DrawingView
import com.example.view.GameActivity
import com.example.view.R

class Haelterman(override var position : Position) : Character(position) {
    private var color = Color.BLUE

    override lateinit var shape: RectF
    override fun draw(canvas: Canvas?) {
        val paint = Paint()
        shape = RectF(
            position.convertPositionToScreen()[0],
            position.convertPositionToScreen()[1],
            position.convertPositionToScreen()[0] + 200f,
            position.convertPositionToScreen()[1] + 200f
        )
        paint.color = color
        canvas?.drawOval(shape, paint)
    }

    private fun getOppositeDirection(direction: Direction?): Direction? {
        return when(direction){
            Direction.DOWN -> Direction.UP
            Direction.LEFT -> Direction.RIGHT
            Direction.UP -> Direction.DOWN
            Direction.RIGHT -> Direction.LEFT
            else -> return null
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun move(direction : Direction, drawingView: DrawingView, gameActivity: GameActivity){

        // Computing the desired position and checking the outcome
        val nextPosition: Position =  when(direction){
            Direction.UP -> Position(position.x, position.y - 1)
            Direction.DOWN -> Position(position.x, position.y + 1)
            Direction.LEFT -> Position(position.x - 1, position.y)
            Direction.RIGHT -> Position(position.x + 1, position.y)
        }

        val currentSquare: Square? = Game.levels[Game.currentLevel].board.getSquareFromPosition(position)
        val nextSquare: Square? = Game.levels[Game.currentLevel].board.getSquareFromPosition(nextPosition)
        if(currentSquare != null)
        {
            // There is a square where user wants to go
            if(currentSquare.obstacle?.direction != direction &&
                getOppositeDirection(nextSquare?.obstacle?.direction) != direction){
                // The obstacle on which is on the same square as the user is in a different direction as the direction where the user wants to go
                this.position = nextPosition // Updating position


            }
            else{
                // User hurt a wall, phones vibrates and user does not move
                val vibrator = gameActivity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    vibrator.vibrate(200)
                }
            }
        }
        else{
            // Showing dead message and putting the character in -1, -1 so it is invisible
            val builder =AlertDialog.Builder(gameActivity)
            builder.setMessage(R.string.dialog_character_fallen_message)
                .setTitle(R.string.dialog_character_fallen_title).show();
            this.position = Position(-1, -1)
        }
        drawingView.invalidate()

}
}