package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log

class Haelterman(override var position : Position) : Character(position) {
    private val paint = Paint()
    private var color = Color.BLUE

    override lateinit var shape: RectF
    override fun draw(canvas: Canvas?) {
        shape = RectF(
            position.convertPositionToScreen(position)[0],
            position.convertPositionToScreen(position)[1],
            position.convertPositionToScreen(position)[0] + 200f,
            position.convertPositionToScreen(position)[1] + 200f
        )
        paint.color = color
        canvas?.drawOval(shape, paint)
    }


    override fun move(direction : Direction){
        Log.d("LOGJ ", "te")

    }



    /*override fun moveTop(){
        position[1] = position[1] + squarePerMove
    }
    override fun moveBottom(){
        position[1] = position[1] - squarePerMove
    }
    override fun moveLeft(){
        position[0] = position[0] - squarePerMove
    }
    override fun moveRight(){
        position[0] = position[0] + squarePerMove
    }*/

}