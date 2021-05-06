package model

interface ScreenConverter {
    fun convertPositionToScreen(position: Array<Int>): Array<Float> {
        // Width/ Height spacing got from Game object
        val x = (Game.widthSpacing * position[0]).toFloat()
        val y = (Game.heightSpacing * position[1])

        return arrayOf(x, y)
    }
}