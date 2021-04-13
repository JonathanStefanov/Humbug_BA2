package model

import android.app.Application
public class Game : Application() {
    companion object {
        @JvmField
        var currentLevel: Int = 0
        var level0: Level = Level(5,
            5,
            characters = arrayOf(Jonathan(Position(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(Square(), Square(obstacle = WallObstacle(Direction.DOWN)), Square(), null, Square()),
                    arrayOf(Square(), Square(), null, null, Square()),
                    arrayOf(null, Square(), Square(), Square(), Square()),
                    arrayOf(null, Square(obstacle = WallObstacle(Direction.RIGHT)), Square(), null, Square()),
                    arrayOf(Square(), Square(), Square(), null, Square()),
                    arrayOf(Square(), Square(squareType = SquareType.STAR), Square(), null, Square())

                    )
            ))
            /*Board(
                arrayOf(
                    arrayOf(Square(null, Position(0,0), SquareType.GRASS), Square(null, Position(1,0), SquareType.GRASS), Square(null, Position(2,0), SquareType.GRASS), null, Square(null, Position(4,0), SquareType.GRASS)),
                    arrayOf(Square(null, Position(0,1), SquareType.GRASS), Square(null, Position(1,1), SquareType.GRASS), Square(null, Position(2,1), SquareType.GRASS), Square(null, Position(3,1), SquareType.STAR), Square(null, Position(4,1), SquareType.GRASS)),
                    arrayOf(Square(null, Position(0,2), SquareType.GRASS), Square(null, Position(1,2), SquareType.GRASS), Square(null, Position(2,2), SquareType.GRASS), Square(null, Position(3,2), SquareType.GRASS), Square(null, Position(4,2), SquareType.GRASS)),
                    arrayOf(Square(null, Position(0,3), SquareType.GRASS), Square(null, Position(1,3), SquareType.GRASS), Square(null, Position(2,3), SquareType.GRASS), Square(null, Position(3,3), SquareType.GRASS), Square(null, Position(4,3), SquareType.GRASS)),
                    arrayOf(null, Square(null, Position(1,4), SquareType.GRASS), Square(null, Position(2,4), SquareType.GRASS), Square(null, Position(3,4), SquareType.GRASS), Square(null, Position(4,4), SquareType.GRASS)),
                    arrayOf(Square(null, Position(0,5), SquareType.GRASS), Square(null, Position(1,5), SquareType.STAR), Square(null, Position(2,5), SquareType.GRASS), Square(null, Position(3,5), SquareType.GRASS), Square(null, Position(4,5), SquareType.GRASS))
                )
            )
        )*/

        var screenHeight = 500
        var screenWidth = 200

        // Getting the spacing by dividing screen seize by matrix size
        var widthSpacing = screenWidth.toFloat()/5
        var heightSpacing = screenHeight.toFloat()/6
        var levels: Array<Level> = arrayOf(level0)


    }
}