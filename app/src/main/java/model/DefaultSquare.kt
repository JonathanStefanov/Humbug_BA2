package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import com.example.view.DrawingView

class DefaultSquare(override var obstacle: Obstacle? = null, override var squareType: SquareType = SquareType.DEFAULT) : Square(squareType, obstacle){
    override fun actionOnSquare(character: Character){
        obstacle?.actionOnObstacle()
    }


    override fun draw(
        canvas: Canvas?,
        position: Position,
        drawingView: DrawingView
    ) {
        // Canvas: Object on which you draw on the drawingview
        // Drawing the square
        val paint = Paint()
        var color = Color.BLACK
        val squareShape = RectF(
            position.convertPositionToScreen()[0],
            position.convertPositionToScreen()[1],
            position.convertPositionToScreen()[0] + 200f,
            position.convertPositionToScreen()[1] + 200f
        )


        paint.color = color
        canvas?.drawRect(squareShape, paint)

        // Drawing the obstacle
        obstacle?.draw(canvas, position, drawingView)


    }
}