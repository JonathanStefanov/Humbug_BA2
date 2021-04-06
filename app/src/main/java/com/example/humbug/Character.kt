package com.example.humbug

abstract class Character {

    abstract val squarePerMove: Int
    abstract var position : Array<Int>

    abstract fun moveTop()
    abstract fun moveBottom()
    abstract fun moveLeft()
    abstract fun moveRight()


}