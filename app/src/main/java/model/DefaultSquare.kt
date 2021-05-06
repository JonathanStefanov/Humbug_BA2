package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.widget.ArrayAdapter
import com.example.view.DrawingView

class DefaultSquare(override var obstacle: Obstacle? = null, override var squareType: SquareType = SquareType.DEFAULT) : Square(squareType, obstacle){
    override fun actionOnSquare(character: Character, level: Level){
        obstacle?.actionOnObstacle(level)
    }


    override fun drawSquare(
        canvas: Canvas?,
        position: Array<Int>,
        drawingView: DrawingView
    ) {
        // Drawing the square
        val paint = Paint()
        var color = Color.BLACK
        val squareShape = RectF(
            this.convertPositionToScreen(position)[0],
            this.convertPositionToScreen(position)[1],
            this.convertPositionToScreen(position)[0] + 200f,
            this.convertPositionToScreen(position)[1] + 200f
        )


        paint.color = color
        canvas?.drawRect(squareShape, paint)

        // Drawing the obstacle
        obstacle?.drawObstacle(canvas, position, drawingView)


    }
}