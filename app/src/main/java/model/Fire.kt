package model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import com.example.view.DrawingView
import com.example.view.R

class Fire(override var direction: Direction? = null, override var obstacleType: ObstacleType = ObstacleType.FIRE) : Obstacle(obstacleType, direction)  {
    override fun draw(canvas: Canvas?, position: Position, drawingView: DrawingView){

        var paint = Paint()
        val img = BitmapFactory.decodeResource(drawingView.resources, R.drawable.fire)

        val x: Float =  position.convertPositionToScreen()[0] - 35
        val y: Float = position.convertPositionToScreen()[1] + 50
        val resized = Bitmap.createScaledBitmap(img, 250, 150, true)
        paint.isFilterBitmap = true;
        paint.isDither = true;
        canvas?.drawBitmap(resized, x.toFloat(), y.toFloat(), paint)

    }
    override fun actionOnObstacle() {
        // -1 life
        Game.levels[Game.selectedLevel].lifeBar = Game.levels[Game.selectedLevel].lifeBar -1

    }
}