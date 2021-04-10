package com.example.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val button: Button = findViewById(R.id.button_play)
        button.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, GameActivity::class.java)
            startActivity(intent)
        }

    }
}