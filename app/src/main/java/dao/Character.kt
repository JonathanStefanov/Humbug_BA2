package dao

abstract class Character(var position : Array<Int>) {

    abstract val squarePerMove: Int

    abstract fun moveTop()
    abstract fun moveBottom()
    abstract fun moveLeft()
    abstract fun moveRight()


}