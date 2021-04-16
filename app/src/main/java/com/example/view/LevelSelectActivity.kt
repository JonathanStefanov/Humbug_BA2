package com.example.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_level_select.*
import model.Game


class LevelSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select)
        val ll_main = findViewById<LinearLayout>(R.id.ll_main_layout)


        Game.levels.forEachIndexed {n, level ->

            // creating the button
            var button = Button(this)
            // setting layout_width and layout_height using layout parameters
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            var j = n+1
            button.text = "Level $j"

            button.setOnClickListener {
                Game.selectedLevel = n
                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
                Log.d("LOL", "Supposed level : $j")

            }
            // add Button to LinearLayout
            ll_main.addView(button)



        }

    }
}



