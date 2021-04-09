package model

class Board(var squares: Array<Array<out Square?>>){
    fun getSquareFromPosition(position: Position): Square? {return squares[position.y][position.x]}
}