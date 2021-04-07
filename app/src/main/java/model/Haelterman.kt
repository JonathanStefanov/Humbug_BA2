package dao

class Haelterman(position: Array<Int>, override val squarePerMove: Int = 3) : Character(position) {


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