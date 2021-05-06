package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import com.example.view.DrawingView

class Wall(override var direction: Direction?, override var obstacleType: ObstacleType = ObstacleType.WALL) : Obstacle(obstacleType, direction) {

    override fun drawObstacle(canvas: Canvas?, position: Array<Int>, drawingView: DrawingView){
        val paint = Paint()
        var color = Color.GREEN
        // Changing the shape depending on the direction
        paint.color = color
        when(direction){
            Direction.UP -> {
                val shape = RectF(
                    this.convertPositionToScreen(position)[0],
                    this.convertPositionToScreen(position)[1],
                    this.convertPositionToScreen(position)[0] + 200f,
                    this.convertPositionToScreen(position)[1] + 50f
                )
                canvas?.drawRect(shape, paint)
            }
            Direction.DOWN -> {
                val shape = RectF(
                    this.convertPositionToScreen(position)[0] ,
                    this.convertPositionToScreen(position)[1] + 150f,
                    this.convertPositionToScreen(position)[0] + 200f,
                    this.convertPositionToScreen(position)[1] + 200f
                )
                canvas?.drawRect(shape, paint)
            }
            Direction.RIGHT -> {
                val shape = RectF(
                    this.convertPositionToScreen(position)[0] + 150 ,
                    this.convertPositionToScreen(position)[1],
                    this.convertPositionToScreen(position)[0] + 200f,
                    this.convertPositionToScreen(position)[1] + 200f
                )
                canvas?.drawRect(shape, paint)
            }
            Direction.LEFT -> {
                val shape = RectF(
                    this.convertPositionToScreen(position)[0] ,
                    this.convertPositionToScreen(position)[1],
                    this.convertPositionToScreen(position)[0] + 50f,
                    this.convertPositionToScreen(position)[1] + 200f
                )
                canvas?.drawRect(shape, paint)
            }
        }




    }

    override fun actionOnObstacle(level: Level) {}

}