package model

import android.graphics.Canvas

abstract class Obstacle(open var obstacleType: ObstacleType, open var direction: Direction){
    abstract fun draw(canvas: Canvas?, position: Position)
    abstract fun actionOnObstacle()
}