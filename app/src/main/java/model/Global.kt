package model

import android.app.Application
public class Global : Application() {
    companion object {
        @JvmField
        var currentLevel: Int = 0
        var level0: Level = Level(5,
            5,
            characters = arrayOf(Haelterman(Position(0,0))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(Square(null, Position(0,0)), Square(null, Position(0,1))),
                    arrayOf(Square(null, Position(1,0)), Square(null, Position(1,1)))
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