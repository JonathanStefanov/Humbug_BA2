package model

import android.app.Application
public class Game : Application() {
    companion object {
        @JvmField
        var currentLevel: Int = 0
        var level0: Level = Level(5,
            5,
            characters = arrayOf(Haelterman(Position(2,2))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(Square(null, Position(0,0)), Square(null, Position(1,0)), Square(null, Position(2,0)), Square(null, Position(3,0)), Square(null, Position(4,0))),
                    arrayOf(Square(null, Position(0,1)), Square(null, Position(1,1)), Square(null, Position(2,1)), Square(null, Position(3,1)), Square(null, Position(4,1))),
                    arrayOf(Square(null, Position(0,2)), Square(null, Position(1,2)), Square(null, Position(2,2)), Square(null, Position(3,2)), Square(null, Position(4,2))),
                    arrayOf(Square(null, Position(0,3)), Square(null, Position(1,3)), Square(null, Position(2,3)), Square(null, Position(3,3)), Square(null, Position(4,3))),
                    arrayOf(Square(null, Position(0,4)), Square(null, Position(1,4)), Square(null, Position(2,4)), Square(null, Position(3,4)), Square(null, Position(4,4))),
                    arrayOf(Square(null, Position(0,5)), StarSquare(null, Position(1,5)), Square(null, Position(2,5)), Square(null, Position(3,5)), Square(null, Position(4,5)))
                )
            )
        )

        var screenHeight = 500
        var screenWidth = 200
        var widthSpacing = screenWidth.toFloat()/5
        var heightSpacing = screenHeight.toFloat()/6
        var levels: Array<Level> = arrayOf(level0)


    }
}