package dao

import dao.Position;

abstract class Character(var position : Position) {

    abstract val squarePerMove: Int

    abstract fun moveTop()
    abstract fun moveBottom()
    abstract fun moveLeft()
    abstract fun moveRight()


}