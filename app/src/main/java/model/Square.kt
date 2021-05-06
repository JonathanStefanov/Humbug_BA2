package model

import android.graphics.Canvas
import com.example.view.DrawingView

abstract class Square(open var squareType: SquareType, open var obstacle: Obstacle?) : ScreenConverter{
    abstract fun actionOnSquare(character: Character, level: Level)
    abstract fun drawSquare(
        canvas: Canvas?,
        position: Array<Int>,
        drawingView: DrawingView
    )


}