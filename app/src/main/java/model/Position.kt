package model

class Position(var x: Int, var y: Int){

    fun convertPositionToScreen(): Array<Float> {
        val x = (Game.widthSpacing * this.x * 5.5).toFloat()
        val y = (Game.heightSpacing * this.y * 3)

        return arrayOf(x, y)

    }
}