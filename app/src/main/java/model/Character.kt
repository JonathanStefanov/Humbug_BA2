package model
import model.Position
import model.Direction
abstract class Character(var position : Position) {

    //abstract val squarePerMove: Int

    abstract fun move(direction : Direction)
    //abstract fun moveTop()
    //abstract fun moveBottom()
    //abstract fun moveLeft()
    //abstract fun moveRight()


}