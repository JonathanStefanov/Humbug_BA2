package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import com.example.view.DrawingView

class Wall(override var direction: Direction?, override var obstacleType: ObstacleType = ObstacleType.WALL) : Obstacle(obstacleType, direction) {

    override fun draw(canvas: Canvas?, position: Position, drawingView: DrawingView){
        val paint = Paint()
        var color = Color.GREEN
        // Changing the shape depending on the direction
        paint.color = color
        when(direction){
            Direction.UP -> {
                val shape = RectF(
                    position.convertPositionToScreen()[0],
                    position.convertPositionToScreen()[1],
                    position.convertPositionToScreen()[0] + 200f,
                    position.convertPositionToScreen()[1] + 50f
                )
                canvas?.drawRect(shape, paint)
            }
            Direction.DOWN -> {
                val shape = RectF(
                    position.convertPositionToScreen()[0] ,
                    position.convertPositionToScreen()[1] + 150f,
                    position.convertPositionToScreen()[0] + 200f,
                    position.convertPositionToScreen()[1] + 200f
                )
                canvas?.drawRect(shape, paint)
            }
            Direction.RIGHT -> {
                val shape = RectF(
                    position.convertPositionToScreen()[0] + 150 ,
                    position.convertPositionToScreen()[1],
                    position.convertPositionToScreen()[0] + 200f,
                    position.convertPositionToScreen()[1] + 200f
                )
                canvas?.drawRect(shape, paint)
            }
            Direction.LEFT -> {
                val shape = RectF(
                    position.convertPositionToScreen()[0] ,
                    position.convertPositionToScreen()[1],
                    position.convertPositionToScreen()[0] + 50f,
                    position.convertPositionToScreen()[1] + 200f
                )
                canvas?.drawRect(shape, paint)
            }
        }




    }

    override fun actionOnObstacle() {}


}