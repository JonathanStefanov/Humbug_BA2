package model
import android.graphics.Canvas
import com.example.view.DrawingView
import com.example.view.GameActivity

abstract class Character(open var position : Array<Int>) : ScreenConverter{
    abstract fun move(
        direction: Direction,
        drawingView: DrawingView,
        gameActivity: GameActivity,
        level: Level
    )
    abstract fun drawCharacter(canvas: Canvas?, drawingView: DrawingView)


}