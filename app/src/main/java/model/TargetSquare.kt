package model

import android.graphics.*
import com.example.view.DrawingView
import com.example.view.R

class TargetSquare(override var obstacle: Obstacle? = null, override var squareType: SquareType = SquareType.TARGET) : Square(squareType, obstacle){
    override fun actionOnSquare(character: Character, level: Level){
        if(this.squareType == SquareType.TARGET){
            // Changing the squaretype to FLAG when character steps on target square
            character.position = arrayOf(-1, -1)
            this.squareType = SquareType.FLAG // Square taken

        }
        obstacle?.actionOnObstacle(level)

    }


    override fun drawSquare(
        canvas: Canvas?,
        position: Array<Int>,
        drawingView: DrawingView
    ) {
        // Canvas: Object on which you draw on the drawingview
        // Drawing the square
        val paint = Paint()
        val squareShape = RectF(
            this.convertPositionToScreen(position)[0],
            this.convertPositionToScreen(position)[1],
            this.convertPositionToScreen(position)[0] + 200f,
            this.convertPositionToScreen(position)[1] + 200f
        )
        var color = Color.YELLOW
        paint.color = color
        canvas?.drawRect(squareShape, paint)

        // Drawing the obstacle
        obstacle?.drawObstacle(canvas, position, drawingView)
        if(this.squareType == SquareType.FLAG){

            val img = BitmapFactory.decodeResource(drawingView.resources, R.drawable.flag)

            val x: Float =  this.convertPositionToScreen(position)[0]
            val y: Float = this.convertPositionToScreen(position)[1]
            val resized = Bitmap.createScaledBitmap(img, 200, 200, true)
            paint.isFilterBitmap = true;
            paint.isDither = true;
            canvas?.drawBitmap(resized, x.toFloat(), y.toFloat(), paint)

        }


    }
}