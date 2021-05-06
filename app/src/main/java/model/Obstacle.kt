package model

import android.graphics.Canvas
import com.example.view.DrawingView

abstract class Obstacle(open var obstacleType: ObstacleType, open var direction: Direction?) : ScreenConverter{
    abstract fun drawObstacle(canvas: Canvas?, position: Array<Int>, drawingView: DrawingView)
    abstract fun actionOnObstacle(level: Level)
}