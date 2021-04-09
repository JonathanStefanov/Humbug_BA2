package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log

open class Square(var squareType: SquareType = SquareType.GRASS, var obstacle: Obstacle? = null)  {
    open fun actionOnSquare(){}


    open fun draw(canvas: Canvas?, position: Position){
        val paint = Paint()
        var color = 0
        val squareShape = RectF(
            position.convertPositionToScreen(position)[0],
            position.convertPositionToScreen(position)[1],
            position.convertPositionToScreen(position)[0] + 200f,
            position.convertPositionToScreen(position)[1] + 200f
        )
        if(squareType == SquareType.GRASS){
             color = Color.BLACK
        }
        else if(squareType == SquareType.STAR){
             color = Color.YELLOW
        }

        paint.color = color
        canvas?.drawRect(squareShape, paint)


    }

}