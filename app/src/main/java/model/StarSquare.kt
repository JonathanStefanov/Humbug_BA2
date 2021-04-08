package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

class StarSquare(obstacle: Obstacle?, position: Position) : Square(obstacle, position) {
    private var color = Color.YELLOW

    fun toGrass(){
        // TODO: Changer le square dans le board
    }

    override fun actionOnSquare() {
        TODO("Not yet implemented")
    }


    override fun draw(canvas: Canvas?){

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