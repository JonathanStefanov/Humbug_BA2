package model

import android.util.DisplayMetrics
import android.view.WindowManager

class Position(var x: Int, var y: Int){

    fun convertPositionToScreen(position: Position): Array<Float> {
        val x = Global.widthSpacing * position.x
        val y = Global.heightSpacing * position.y

        return arrayOf(x, y)

    }
}