package dao

import dao.Obstacle
import dao.Square

class EmptySquare(obstacle: Obstacle) : Square(obstacle) {

    override fun actionOnSquare() {

    }
}