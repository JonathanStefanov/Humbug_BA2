package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import com.example.view.DrawingView

class Haelterman(override var position : Position) : Character(position) {
    private var color = Color.BLUE

    override lateinit var shape: RectF
    override fun draw(canvas: Canvas?) {
        val paint = Paint()
        shape = RectF(
            position.convertPositionToScreen()[0],
            position.convertPositionToScreen()[1],
            position.convertPositionToScreen()[0] + 200f,
            position.convertPositionToScreen()[1] + 200f
        )
        paint.color = color
        canvas?.drawOval(shape, paint)
    }

    private fun getOppositeDirection(direction: Direction?): Direction? {
        return when(direction){
            Direction.DOWN -> Direction.UP
            Direction.LEFT -> Direction.RIGHT
            Direction.UP -> Direction.DOWN
            Direction.RIGHT -> Direction.LEFT
            else -> return null
        }
    }
    override fun move(direction : Direction, drawingView: DrawingView){
/*
        Log.d("LOL", "supposed : " + direction.name)
        Log.d("LOL", "this square : " + Game.levels[Game.currentLevel].board.getSquareFromPosition(this.position)?.obstacle?.direction?.name)
        var nextPosition: Position = position
        when(direction){
            Direction.UP -> nextPosition.y = nextPosition.y - 1
            Direction.DOWN -> nextPosition.y = nextPosition.y + 1
            Direction.LEFT -> nextPosition.x = nextPosition.x - 1
            Direction.RIGHT -> nextPosition.x = nextPosition.x + 1
        }
        Log.d("LOL", "this square : " + getOppositeDirection(Game.levels[Game.currentLevel].board.getSquareFromPosition(nextPosition)?.obstacle?.direction)?.name)

        when(direction){
            Direction.UP -> this.position.y = this.position.y - 1
            Direction.DOWN -> this.position.y = this.position.y + 1
            Direction.LEFT -> this.position.x = this.position.x - 1
            Direction.RIGHT -> this.position.x = this.position.x + 1
        }
        drawingView.invalidate()
*/
        //for(i in 0..3){
            // Check if we can move out of our own square
            if(Game.levels[Game.currentLevel].board.getSquareFromPosition(this.position)?.obstacle?.direction != direction){
                // Check if next square will be valid too
                var nextPosition: Position = position
                when(direction){
                    Direction.UP -> nextPosition.y = nextPosition.y - 1
                    Direction.DOWN -> nextPosition.y = nextPosition.y + 1
                    Direction.LEFT -> nextPosition.x = nextPosition.x - 1
                    Direction.RIGHT -> nextPosition.x = nextPosition.x + 1
                }
                Log.d("LOL", "this square : " + getOppositeDirection(Game.levels[Game.currentLevel].board.getSquareFromPosition(nextPosition)?.obstacle?.direction)?.name)
                // If next square has a square with the opposite direction, not go
                if(getOppositeDirection(Game.levels[Game.currentLevel].board.getSquareFromPosition(nextPosition)?.obstacle?.direction) != direction &&
                    Game.levels[Game.currentLevel].board.getSquareFromPosition(this.position) != null){
                    this.position = nextPosition
                    drawingView.invalidate()
                }
            }
       //}


/*
*                 when(direction){
                Direction.UP -> this.position.y = this.position.y - 1
                Direction.DOWN -> this.position.y = this.position.y + 1
                Direction.LEFT -> this.position.x = this.position.x - 1
                Direction.RIGHT -> this.position.x = this.position.x + 1
            }
* */


    /*override fun moveTop(){
        position[1] = position[1] + squarePerMove
    }
    override fun moveBottom(){
        position[1] = position[1] - squarePerMove
    }
    override fun moveLeft(){
        position[0] = position[0] - squarePerMove
    }
    override fun moveRight(){
        position[0] = position[0] + squarePerMove
    }*/

}
}