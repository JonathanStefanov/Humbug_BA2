package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import com.example.view.DrawingView

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


    override fun move(direction : Direction, drawingView: DrawingView){

        Log.d("LOL", "supposed : " + direction.name)
        when(direction){
            Direction.UP -> this.position.y = this.position.y - 1
            Direction.DOWN -> this.position.y = this.position.y + 1
            Direction.LEFT -> this.position.x = this.position.x - 1
            Direction.RIGHT -> this.position.x = this.position.x + 1
        }
        drawingView.invalidate()


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