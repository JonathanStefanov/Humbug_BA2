package model

import android.graphics.Canvas

abstract class Obstacle(obstacleType: ObstacleType){
    abstract fun draw(canvas: Canvas?, position: Position)
}