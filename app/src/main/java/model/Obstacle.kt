package model

import android.graphics.Canvas
import com.example.view.DrawingView

abstract class Obstacle(open var obstacleType: ObstacleType, open var direction: Direction?){
    abstract fun drawObstacle(canvas: Canvas?, position: Position, drawingView: DrawingView)
    abstract fun actionOnObstacle()
}