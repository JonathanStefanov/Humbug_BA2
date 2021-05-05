package model

import android.graphics.Canvas
import com.example.view.DrawingView

abstract class Square(open var squareType: SquareType, open var obstacle: Obstacle?)  {
    abstract fun actionOnSquare(character: Character)
    abstract fun drawSquare(
        canvas: Canvas?,
        position: Position,
        drawingView: DrawingView
    )


}