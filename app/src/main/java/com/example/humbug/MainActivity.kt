package com.example.humbug

import android.graphics.Canvas
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val canvas = Canvas()
        canvas.drawRect(
            Rect(startX, topY, endX, bottomY),
            paint)

        /*val p1 = Haelterman(arrayOf<Int>(0,0))
        p1.moveTop()
        p1.moveLeft()
        Log.d("pos", "x : " + p1.position[0].toString() + " y : " + p1.position[1].toString())*/


        /*var board = Board(
            arrayOf(
                arrayOf(GrassSquare(null), StarSquare(null)),
                arrayOf(
                    GrassSquare(null),
                    GrassSquare(null)
                )
            )
        )*/

    }
}
