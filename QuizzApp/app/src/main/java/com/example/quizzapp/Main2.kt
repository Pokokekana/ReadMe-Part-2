package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Main2 : AppCompatActivity() {

    private val questions = arrayOf(
        "Julius Caesar died in 44 BC.",
        "Adolf Hitler was murdered in 1945.",
        "The Springboks won their first championship in 1995.",
        "The Great Wall of China was built in between the 8th and 5th century BC.",
        "Martin Luther King JR has delivered his iconic and inspirational speech in 1968."
    )
    private val answers = arrayOf(true, false, true, true, false)
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)

        fun loadQuestion() {
            txtQuestion.text = questions[currentQuestionIndex]
            txtResult.text = ""
        }
        loadQuestion()

        btnTrue.setOnClickListener {
            checkAnswer(true, txtResult)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false, txtResult)
        }

        btnNext.setOnClickListener {
            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                loadQuestion()
            } else {
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun checkAnswer(userAnswer: Boolean, txtResult: TextView) {
        if (currentQuestionIndex >= answers.size) {
            txtResult.text = "Error: No more questions!"
            return
        }
        if (userAnswer == answers[currentQuestionIndex]) {
            txtResult.text = "Correct"
            score++
        } else {
            txtResult.text = "Incorrect"
        }
    }
}
