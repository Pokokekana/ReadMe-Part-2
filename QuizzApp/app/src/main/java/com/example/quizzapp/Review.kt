package com.example.quizzapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val txtAnswers = findViewById<TextView>(R.id.txtAnswers)
        val questions = arrayOf(
            "Julius Caesar died in 44 BC.",
            "Adolf Hitler was murdered in 1945.",
            "The springboks won their first championship in 1995",
            "The Great Wall of China was built in between the 8th and 5th centuries BC",
            "Martin Luther King JR has delivered his iconic and monumental speech in 1968"
        )
        val answers = arrayOf(true, false, true, true, false)

        val builder = buildString {
            for (i in questions.indices) {
                val txtAnswers = if (answers[i]) "correct" else "incorrect"
                append("Q: ${questions[i]}\nA: ${answers[i]}\n\n")
            }
        }


        txtAnswers.text = builder.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}