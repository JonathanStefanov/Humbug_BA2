package model

import android.graphics.*
import com.example.view.DrawingView
import com.example.view.R

class TargetSquare(override var obstacle: Obstacle? = null, override var squareType: SquareType = SquareType.TARGET) : Square(squareType, obstacle){
    override fun actionOnSquare(character: Character){
        if(this.squareType == SquareType.TARGET){
            character.position = Position(-1, -1)
            this.squareType = SquareType.FLAG // Square taken

        }
        obstacle?.actionOnObstacle()

    }


    override fun draw(
        canvas: Canvas?,
        position: Position,
        drawingView: DrawingView
    ) {
        // Canvas: Object on which you draw on the drawingview
        // Drawing the square
        val paint = Paint()
        val squareShape = RectF(
            position.convertPositionToScreen()[0],
            position.convertPositionToScreen()[1],
            position.convertPositionToScreen()[0] + 200f,
            position.convertPositionToScreen()[1] + 200f
        )
        var color = Color.YELLOW
        paint.color = color
        canvas?.drawRect(squareShape, paint)

        // Drawing the obstacle
        obstacle?.draw(canvas, position, drawingView)
        if(this.squareType == SquareType.FLAG){

            val img = BitmapFactory.decodeResource(drawingView.resources, R.drawable.flag)

            val x: Float =  position.convertPositionToScreen()[0]
            val y: Float = position.convertPositionToScreen()[1]
            val resized = Bitmap.createScaledBitmap(img, 200, 200, true)
            paint.isFilterBitmap = true;
            paint.isDither = true;
            canvas?.drawBitmap(resized, x.toFloat(), y.toFloat(), paint)

        }


    }
}