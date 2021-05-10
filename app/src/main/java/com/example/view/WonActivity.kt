package com.example.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import model.Game

class WonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        val buttonLevelSelect: Button = findViewById(R.id.LevelMenu)
        val buttonNextLevel: Button = findViewById(R.id.NextLevel)
        buttonLevelSelect.setOnClickListener {
            val intent = Intent(this, LevelSelectActivity::class.java)
            startActivity(intent)
        }
        buttonNextLevel.setOnClickListener {
            Game.selectedLevel += 1
            if (Game.selectedLevel > 3) {
                Game.selectedLevel = 0
        }
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}