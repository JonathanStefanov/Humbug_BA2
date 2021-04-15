package com.example.humbug

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_win.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

<<<<<<< Updated upstream:app/src/main/java/com/example/humbug/WelcomeActivity.kt
        val button: Button = findViewById(R.id.button_play)
        button.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
=======
        val buttonwelcome: Button = findViewById(R.id.button_play)
        buttonwelcome.setOnClickListener {
            val intent = Intent(this, LevelSelect::class.java)
>>>>>>> Stashed changes:app/src/main/java/com/example/view/WelcomeActivity.kt
            startActivity(intent)
        }

    }
}