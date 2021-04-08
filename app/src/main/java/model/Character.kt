package model
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.RectF
import model.Position
import model.Direction
abstract class Character(open var position : Position) {

    //abstract val squarePerMove: Int

    abstract var shape: RectF
    abstract fun move(direction : Direction)
    abstract fun draw(canvas: Canvas?)
    //abstract fun moveTop()
    //abstract fun moveBottom()
    //abstract fun moveLeft()
    //abstract fun moveRight()


}