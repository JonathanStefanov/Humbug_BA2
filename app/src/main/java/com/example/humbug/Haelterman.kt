package com.example.humbug

class Haelterman(override var position: Array<Int>, override val squarePerMove: Int = 3) : Character() {


    override fun moveTop(){
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
    }
}