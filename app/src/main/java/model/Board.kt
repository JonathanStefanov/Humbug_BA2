package model

class Board(var squares: Array<Array<out Square?>>){
    fun getSquareFromPosition(position: Position): Square? {return squares.elementAtOrNull(position.y)?.elementAtOrNull(position.x)}
}