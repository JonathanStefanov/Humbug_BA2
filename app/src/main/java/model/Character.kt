package model
import android.graphics.Canvas
import android.graphics.RectF
import com.example.view.DrawingView
import com.example.view.GameActivity

abstract class Character(open var position : Position) {
    abstract fun move(
        direction: Direction,
        drawingView: DrawingView,
        gameActivity: GameActivity
    )
    abstract fun drawCharacter(canvas: Canvas?, drawingView: DrawingView)


}