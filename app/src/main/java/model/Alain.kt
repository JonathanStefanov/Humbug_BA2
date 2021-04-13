package model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toDrawable
import com.example.view.DrawingView
import com.example.view.GameActivity
import com.example.view.R

class Alain(override var position : Position) : Character(position)  {
    override fun move(direction: Direction, drawingView: DrawingView, gameActivity: GameActivity) {
        TODO("Not yet implemented")
    }

    override fun draw(canvas: Canvas?, drawingView: DrawingView) {
        val paint = Paint()

        val drawable: Drawable = R.drawable.spikes.toDrawable() // Getting the picture
        val img = BitmapFactory.decodeResource(drawingView.resources, R.drawable.alain)

        val x: Float =  position.convertPositionToScreen()[0] - 30f // -50f to recenter the image
        val y: Float = position.convertPositionToScreen()[1] - 30f
        val resized = Bitmap.createScaledBitmap(img, 250, 280, true)
        paint.isFilterBitmap = true;
        paint.isDither = true;
        canvas?.drawBitmap(resized, x.toFloat(), y.toFloat(), paint)
    }
}