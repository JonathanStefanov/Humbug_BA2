package com.example.humbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val p1 = Haelterman(arrayOf<Int>(0,0))
        p1.moveTop()
        p1.moveLeft()
        Log.d("pos", "x : " + p1.position[0].toString() + " y : " + p1.position[1].toString())
    }
}
