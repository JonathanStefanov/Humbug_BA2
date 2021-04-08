package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log

open class Square(var obstacle: Obstacle?, var position: Position) {
    private val paint = Paint()
    private val squareShape = RectF(
        position.convertPositionToScreen(position)[0],
        position.convertPositionToScreen(position)[1],
        200F,
        200F)
    private var color = Color.GREEN


    open fun actionOnSquare(){}

    fun draw(canvas: Canvas?){
        paint.color = color
        canvas?.drawRect(squareShape, paint)

        Log.d("APPLI", "x : " + position.convertPositionToScreen(position)[0].toString() + " y : " + position.convertPositionToScreen(position)[1].toString())




    }

}