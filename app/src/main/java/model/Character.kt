package model
import android.graphics.Canvas
import com.example.view.DrawingView
import com.example.view.GameActivity

abstract class Character(open var position : Array<Int>) : ScreenConverter{
    abstract fun move(
        direction: Direction,
        level: Level
    ) : Boolean
    abstract fun drawCharacter(canvas: Canvas?, drawingView: DrawingView)

    protected fun getOppositeDirection(direction: Direction?): Direction? {
        return when(direction){
            Direction.DOWN -> Direction.UP
            Direction.LEFT -> Direction.RIGHT
            Direction.UP -> Direction.DOWN
            Direction.RIGHT -> Direction.LEFT
            else -> return null
        }
    }


}