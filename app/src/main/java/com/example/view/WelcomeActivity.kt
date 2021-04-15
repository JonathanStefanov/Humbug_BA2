package com.example.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_win.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val buttonwelcome: Button = findViewById(R.id.button_play)
        buttonwelcome.setOnClickListener {
            val intent = Intent(this, LevelSelect::class.java)
            startActivity(intent)
        }

    }
}