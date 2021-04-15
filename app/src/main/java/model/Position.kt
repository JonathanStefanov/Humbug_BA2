package model

class Position(var x: Int, var y: Int){

    fun convertPositionToScreen(): Array<Float> {
        // Width/ Heigth spacing got from Game object
        // * 5,5 and *3 to augment spacing empirically
        // TODO idea for fix y a moyen c pske lékran il é en ho dcp do fair - 200ou autre en vrai psk ça depend
        val x = (Game.widthSpacing * this.x * 5.5).toFloat()
        val y = (Game.heightSpacing * this.y * 3)


        return arrayOf(x, y)

    }
}