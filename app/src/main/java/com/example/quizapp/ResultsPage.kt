package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_page)

        var counter = intent.getStringExtra("RESULT")
        var score = findViewById<TextView>(R.id.score)
        score.text = counter

        var backButton: TextView = findViewById<Button>(R.id.restart)
        backButton.setOnClickListener() {


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }


    }
}
