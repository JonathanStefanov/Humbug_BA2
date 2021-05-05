package model

class Position(var x: Int, var y: Int){

    

    fun convertPositionToScreen(): Array<Float> {
        // Width/ Height spacing got from Game object
        val x = (Game.widthSpacing * this.x).toFloat()
        val y = (Game.heightSpacing * this.y)


        return arrayOf(x, y)

    }
}