package model
import android.graphics.Canvas
import android.graphics.RectF
import com.example.view.DrawingView

abstract class Character(open var position : Position) {

    //abstract val squarePerMove: Int

    abstract var shape: RectF
    abstract fun move(direction: Direction, drawingView: DrawingView)
    abstract fun draw(canvas: Canvas?)
    //abstract fun moveTop()
    //abstract fun moveBottom()
    //abstract fun moveLeft()
    //abstract fun moveRight()


}