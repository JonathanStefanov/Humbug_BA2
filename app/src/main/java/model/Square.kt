package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

open class Square(var squareType: SquareType = SquareType.GRASS, var obstacle: Obstacle? = null)  {
    open fun actionOnSquare(){
        if(squareType == SquareType.STAR){ squareType = SquareType.GRASS }
        obstacle?.actionOnObstacle()
    }


    open fun draw(canvas: Canvas?, position: Position){
        // Canvas: Object on which you draw on the drawinfview
        // Drawing the square
        val paint = Paint()
        var color = 0
        val squareShape = RectF(
            position.convertPositionToScreen()[0],
            position.convertPositionToScreen()[1],
            position.convertPositionToScreen()[0] + 200f,
            position.convertPositionToScreen()[1] + 200f
        )
        if(squareType == SquareType.GRASS){
             color = Color.BLACK
        }
        else if(squareType == SquareType.STAR){
             color = Color.YELLOW
        }

        paint.color = color
        canvas?.drawRect(squareShape, paint)

        // Drawing the obstacle
        obstacle?.draw(canvas, position)


    }

}