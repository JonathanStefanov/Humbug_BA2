package model

import android.app.Application

public class Game : Application() {
    companion object {
        @JvmField
        
        var level0: Level = Level(4,
            4,
            characters = arrayOf(Alain(Position(2, 4)), Dylan(Position(1,1)), Jonathan(Position(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), null, null, DefaultSquare()),
                    arrayOf(null, DefaultSquare(), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), TargetSquare(), DefaultSquare(obstacle = Spikes()), null, DefaultSquare())

                    )
            ))
        var level1: Level = Level(6,
            5,
            characters = arrayOf(Alain(Position(2, 2)), Dylan(Position(1,3)), Jonathan(Position(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.DOWN)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), null, null, DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Fire()), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Spikes()), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(TargetSquare(), TargetSquare(), DefaultSquare(obstacle = Spikes()), null, DefaultSquare())

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
        var selectedLevel: Int = 0
        var levels: Array<Level> = arrayOf(level0, level1)
        var selectedCharacter: Character = levels[selectedLevel].characters[0]
        var screenHeight = 500
        var screenWidth = 200

        // Getting the spacing by dividing screen seize by matrix size
        var widthSpacing = screenWidth.toFloat()/5
        var heightSpacing = screenHeight.toFloat()/6


    }
}