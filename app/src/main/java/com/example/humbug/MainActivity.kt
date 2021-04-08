package com.example.humbug

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import model.Global


class MainActivity : AppCompatActivity() {
    lateinit var drawingView: DrawingView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics = DisplayMetrics()
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        Global.screenHeight = height
        Global.screenWidth = width
        drawingView = findViewById(R.id.vMain)
        drawingView.setWillNotDraw(false)
        drawingView.invalidate()


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
