package model

import android.app.Application

class Game : Application() {
    companion object {
        @JvmField
        // creating all the levels + their copy because deep copy hardly feasible in Kotlin
        var level0Copy: Level = Level(4,
            4,
            characters = arrayOf(Alain(arrayOf(2, 4)), Dylan(arrayOf(1,1)), Jonathan(arrayOf(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            squares =
                arrayOf(
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), null, null, DefaultSquare()),
                    arrayOf(null, DefaultSquare(), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), TargetSquare(), DefaultSquare(obstacle = Spikes()), null, DefaultSquare())

                )
            )
        var level1Copy: Level = Level(6,
            5,
            characters = arrayOf(Alain(arrayOf(2, 2)), Dylan(arrayOf(1,3)), Jonathan(arrayOf(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            squares =
                arrayOf(
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.DOWN)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(TargetSquare(), DefaultSquare(), null, null, DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Fire()), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Spikes()), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), TargetSquare(), DefaultSquare(obstacle = Spikes()), null, DefaultSquare())

            ))

        var level2Copy: Level = Level(10,
            5,
            characters = arrayOf(Alain(arrayOf(3, 3)), Dylan(arrayOf(2,4)), Jonathan(arrayOf(4,5 ))),
            status = LevelStatus.IN_PROGRESS,
            squares =
            arrayOf(
                arrayOf(null, null, DefaultSquare(obstacle = Wall(Direction.UP)), DefaultSquare(), TargetSquare()),
                arrayOf(null, null, DefaultSquare(), null, DefaultSquare(obstacle = Spikes())),
                arrayOf(null, null, DefaultSquare(), DefaultSquare(), DefaultSquare()),
                arrayOf(TargetSquare(), DefaultSquare(), DefaultSquare(obstacle = Spikes()), DefaultSquare(), null),
                arrayOf(null, DefaultSquare(obstacle = Wall(Direction.LEFT)), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                arrayOf(null, TargetSquare(), DefaultSquare(obstacle = Fire()), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)))

            ))
        var level0: Level = Level(4,
            4,
            characters = arrayOf(Alain(arrayOf(2, 4)), Dylan(arrayOf(1,1)), Jonathan(arrayOf(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            squares =
                arrayOf(
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), null, null, DefaultSquare()),
                    arrayOf(null, DefaultSquare(), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), TargetSquare(), DefaultSquare(obstacle = Spikes()), null, DefaultSquare())
            ))
        var level1: Level = Level(7,
            4,
            characters = arrayOf(Alain(arrayOf(2, 2)), Dylan(arrayOf(1,3)), Jonathan(arrayOf(3,2 ))),
            status = LevelStatus.IN_PROGRESS,
            squares =
                arrayOf(
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.DOWN)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(TargetSquare(), DefaultSquare(), null, null, DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Fire()), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.RIGHT)), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), DefaultSquare(obstacle = Spikes()), DefaultSquare(), null, DefaultSquare()),
                    arrayOf(DefaultSquare(), TargetSquare(), DefaultSquare(obstacle = Spikes()), null, DefaultSquare())

            ))

        var level2: Level = Level(10,
            5,
            characters = arrayOf(Alain(arrayOf(3, 3)), Dylan(arrayOf(2,4)), Jonathan(arrayOf(4,5 ))),
            status = LevelStatus.IN_PROGRESS,
            squares =
                arrayOf(
                    arrayOf(null, null, DefaultSquare(obstacle = Wall(Direction.UP)), DefaultSquare(), TargetSquare()),
                    arrayOf(null, null, DefaultSquare(), null, DefaultSquare(obstacle = Spikes())),
                    arrayOf(null, null, DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(TargetSquare(), DefaultSquare(), DefaultSquare(obstacle = Spikes()), DefaultSquare(), null),
                    arrayOf(null, DefaultSquare(obstacle = Wall(Direction.LEFT)), DefaultSquare(), DefaultSquare(), DefaultSquare()),
                    arrayOf(null, TargetSquare(), DefaultSquare(obstacle = Fire()), DefaultSquare(), DefaultSquare(obstacle = Wall(Direction.DOWN)))

            ))

        var selectedLevel: Int = 0
        var untouchedLevels: Array<Level> = arrayOf(level0Copy, level1Copy, level2Copy)
        var levels: Array<Level> = arrayOf(level0, level1, level2)
        var selectedCharacter: Character = levels[selectedLevel].characters[0]
        var screenHeight = 0
        var screenWidth = 0
        var widthSpacing = 0f
        var heightSpacing = 0f


    }
}