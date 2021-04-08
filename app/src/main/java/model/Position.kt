package model

class Position(var x: Int, var y: Int){

    fun convertPositionToScreen(position: Position): Array<Float> {
        val x = (Game.widthSpacing * position.x * 5.5).toFloat()
        val y = (Game.heightSpacing * position.y * 3)

        return arrayOf(x, y)

    }
}