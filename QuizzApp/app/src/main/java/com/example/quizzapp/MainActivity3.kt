package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val score = intent.getIntExtra("score", 0)
        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnOut = findViewById<Button>(R.id.btnOut)

        txtScore.text = "Your score: $score / 5"
        txtFeedback.text = if (score >= 3) "Good work" else "Keep practicing"

        btnReview.setOnClickListener {
            val intent = Intent(this, Review::class.java)
            startActivity(intent)
        }

        btnOut.setOnClickListener {
            finishAffinity()
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}