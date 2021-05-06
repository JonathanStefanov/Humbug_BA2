package model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import com.example.view.DrawingView
import com.example.view.R

class Spikes(override var direction: Direction? = null, override var obstacleType: ObstacleType = ObstacleType.SPIKES) : Obstacle(obstacleType, direction)  {
    override fun drawObstacle(canvas: Canvas?, position: Array<Int>, drawingView: DrawingView){

        var paint = Paint()
        val img = BitmapFactory.decodeResource(drawingView.resources, R.drawable.spikes)

        val x: Float =  this.convertPositionToScreen(position)[0]
        val y: Float = this.convertPositionToScreen(position)[1] + 70
        val resized = Bitmap.createScaledBitmap(img, 200, 130, true)
        paint.isFilterBitmap = true
        paint.isDither = true
        canvas?.drawBitmap(resized, x.toFloat(), y.toFloat(), paint)

    }
    override fun actionOnObstacle(level: Level) {
        // -1 life
        level.decreaseLife(1)

    }
}