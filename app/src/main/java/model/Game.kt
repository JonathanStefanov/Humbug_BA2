package model

import android.app.Application

public class Game : Application() {
    companion object {
        @JvmField
        var level0Copy: Level = Level(4,
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
        var level1Copy: Level = Level(6,
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
        var level2Copy: Level = Level(13,
            3,
            characters = arrayOf(Alain(Position(1, 0)), Dylan(Position(1,3)), Jonathan(Position(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.UP)), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.UP)), TargetSquare()),
                    arrayOf(DefaultSquare(obstacle = Spikes()), DefaultSquare(), null, DefaultSquare(), null),
                    arrayOf(TargetSquare(),DefaultSquare(obstacle = Fire()), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), DefaultSquare(), DefaultSquare(obstacle = Fire()), DefaultSquare(obstacle = Wall(Direction.LEFT))),
                    arrayOf(null, null, DefaultSquare(), DefaultSquare(), DefaultSquare(obstacle = Spikes())),
                    arrayOf(null, null, DefaultSquare(), TargetSquare(obstacle = Wall(Direction.LEFT)), DefaultSquare())

                )
            ))
        var level3Copy: Level = Level(15,
            7,
            characters = arrayOf(Alain(Position(2, 0)), Dylan(Position(0,0)), Jonathan(Position(4,1 ))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(DefaultSquare(), DefaultSquare(), DefaultSquare(obstacle = Fire()), DefaultSquare(), TargetSquare(obstacle = Wall(Direction.RIGHT))),
                    arrayOf(DefaultSquare(obstacle = Wall(Direction.UP)), DefaultSquare(), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(obstacle = Spikes())),
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.UP)), DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(), TargetSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), TargetSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.LEFT)), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)), DefaultSquare()),
                    arrayOf(DefaultSquare(obstacle = Wall(Direction.LEFT)), DefaultSquare(), DefaultSquare(obstacle = Spikes()), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)))

                )
            ))
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
        var level1: Level = Level(7,
            4,
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
        var level2: Level = Level(13,
            3,
            characters = arrayOf(Alain(Position(1, 0)), Dylan(Position(1,3)), Jonathan(Position(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.UP)), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.UP)), TargetSquare()),
                    arrayOf(DefaultSquare(obstacle = Spikes()), DefaultSquare(), null, DefaultSquare(), null),
                    arrayOf(DefaultSquare(),DefaultSquare(obstacle = Fire()), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), DefaultSquare(), DefaultSquare(obstacle = Fire()), DefaultSquare(obstacle = Wall(Direction.LEFT))),
                    arrayOf(null, null, DefaultSquare(), DefaultSquare(), DefaultSquare(obstacle = Spikes())),
                    arrayOf(null, null, DefaultSquare(), TargetSquare(obstacle = Wall(Direction.LEFT)), DefaultSquare())

                )
            ))
        var level3: Level = Level(15,
            7,
            characters = arrayOf(Alain(Position(2, 0)), Dylan(Position(0,0)), Jonathan(Position(4,1 ))),
            status = LevelStatus.IN_PROGRESS,
            board = Board(
                arrayOf(
                    arrayOf(DefaultSquare(), DefaultSquare(), DefaultSquare(obstacle = Fire()), DefaultSquare(), TargetSquare(obstacle = Wall(Direction.RIGHT))),
                    arrayOf(DefaultSquare(obstacle = Wall(Direction.UP)), DefaultSquare(), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(obstacle = Spikes())),
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.UP)), DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(), TargetSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), TargetSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.LEFT)), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)), DefaultSquare()),
                    arrayOf(DefaultSquare(obstacle = Wall(Direction.LEFT)), DefaultSquare(), DefaultSquare(obstacle = Spikes()), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)))

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
        var untouchedLevels: Array<Level> = arrayOf(level0Copy, level1Copy, level2Copy, level3Copy)
        var levels: Array<Level> = arrayOf(level0, level1, level2, level3)
        var selectedCharacter: Character = levels[selectedLevel].characters[0]
        var screenHeight = 500
        var screenWidth = 200

        // Getting the spacing by dividing screen seize by matrix size
        var widthSpacing = screenWidth.toFloat()/5
        var heightSpacing = screenHeight.toFloat()/6


    }
}