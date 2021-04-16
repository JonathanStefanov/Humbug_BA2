package com.example.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import model.Game

class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        val buttonwin1: Button = findViewById(R.id.LevelMenu)
        val buttonwin2: Button = findViewById(R.id.NextLevel)
        buttonwin1.setOnClickListener {
            val intent = Intent(this, LevelSelectActivity::class.java)
            startActivity(intent)
        }
        buttonwin2.setOnClickListener {
            Game.selectedLevel += 1
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}