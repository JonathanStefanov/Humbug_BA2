package model

import android.app.AlertDialog
import android.content.Context
import android.graphics.*
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import com.example.view.DrawingView
import com.example.view.GameActivity
import com.example.view.R


class Jonathan(override var position : Array<Int>) : Character(position)  {

    override fun drawCharacter(canvas: Canvas?, drawingView: DrawingView) {
        val paint = Paint()

        val img = BitmapFactory.decodeResource(drawingView.resources, R.drawable.jonathan)

        val x: Float =  this.convertPositionToScreen(position)[0] - 20f
        val y: Float = this.convertPositionToScreen(position)[1] - 20f
        val resized = Bitmap.createScaledBitmap(img, 220, 220, true)
        paint.isFilterBitmap = true;
        paint.isDither = true;
        canvas?.drawBitmap(resized, x.toFloat(), y.toFloat(), paint)


    }


    override fun move(direction: Direction, level: Level): Boolean {
        var canMove:Boolean = false
        // Computing the desired position and checking the outcome
        val nextPosition: Array<Int> = when (direction) {
            Direction.UP -> arrayOf(position[0], position[1] - 1)
            Direction.DOWN -> arrayOf(position[0], position[1]  + 1)
            Direction.LEFT -> arrayOf(position[0] - 1, position[1])
            Direction.RIGHT -> arrayOf(position[0] + 1, position[1] )
        }
        var otherCharacterOnNextPosition = false

        val currentSquare: Square? =
            level.getSquareFromPosition(position)
        val nextSquare: Square? =
            level.getSquareFromPosition(nextPosition)

        for (character in level.characters) {
            if (character.position[0] == nextPosition[0] && character.position[1] == nextPosition[1]) {
                otherCharacterOnNextPosition = true
            }
        }

        if (nextSquare == null) {
            // dead and putting the character in -1, -1 so it is invisible
            canMove = true
            this.position = arrayOf(-1, -1)
        } else if (!otherCharacterOnNextPosition && currentSquare?.obstacle?.direction != direction &&
            getOppositeDirection(nextSquare?.obstacle?.direction) != direction) {
            // User can move!
            canMove = true
            this.position = nextPosition // Updating position
            if(nextSquare?.obstacle?.obstacleType != ObstacleType.SPIKES){
                nextSquare?.actionOnSquare(this, level) // Action on square
            }


        }
        return canMove
    }
}