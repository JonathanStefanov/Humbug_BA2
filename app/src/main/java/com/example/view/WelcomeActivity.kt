package com.example.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import kotlinx.android.synthetic.main.activity_win.*
import model.Game

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val buttonwelcome: Button = findViewById(R.id.button_play)
        buttonwelcome.setOnClickListener {
            val intent = Intent(this, LevelSelectActivity::class.java)
            startActivity(intent)
        }
        setScreenSize()


    }

    private fun setScreenSize(){

        // Will be used to draw the canvas at the correct screen size
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        // Setting the height and width of the screen into the Game class
        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels


        Game.screenHeight = (height*0.6).toInt() // to leave place to the UI
        Game.screenWidth = width

        // Getting the spacing needed between squares
        Game.widthSpacing = Game.screenWidth.toFloat()/5
        Game.heightSpacing = Game.screenHeight.toFloat()/6
    }
}