package com.example.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import model.Game

class LevelSelectedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_selected)
        val ll_main = findViewById(R.id.ll_main_layout) as LinearLayout


        Game.levels.forEachIndexed { n, level ->

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
                Log.d("LOL", "Supposed level : " + j.toString())

            }
            // add Button to LinearLayout
            ll_main.addView(button)



        }

    }
}



