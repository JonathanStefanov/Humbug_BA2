package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log

open class Square(var obstacle: Obstacle?, var position: Position) {
    val paint = Paint()


    private var color = Color.BLACK


    open fun actionOnSquare(){}

    open fun draw(canvas: Canvas?){

        val squareShape = RectF(
            position.convertPositionToScreen(position)[0],
            position.convertPositionToScreen(position)[1],
            position.convertPositionToScreen(position)[0] + 200f,
            position.convertPositionToScreen(position)[1] + 200f
        )
        paint.color = color
        canvas?.drawRect(squareShape, paint)

    }

}