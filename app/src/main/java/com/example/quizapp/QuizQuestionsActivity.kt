package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ThreadLocalRandom



class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        var correctOption = generateQuestionAndOptions()

    }
    var counter = 0

    fun generateQuestionAndOptions() : Int{
        val epoch = ThreadLocalRandom.current().nextLong(0, 1623555449)
        var date = Date(epoch * 1000)

        dateGeneration(date)
        var correctOption = optionGenerate(date)
        return correctOption
    }

    fun dateGeneration(date: Date) {

        val formatter = SimpleDateFormat("dd MMM yyyy")
        val strDate = formatter.format(date)

        val dateSelect: TextView = findViewById(R.id.date_picker)
        dateSelect.text =strDate.toString()
    }


    fun optionGenerate(strDate: Date) : Int
    {

        var days: MutableList<String> = mutableListOf<String>(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        )
        val options = mutableListOf(R.id.btn_opt1, R.id.btn_opt2, R.id.btn_opt3, R.id.btn_opt4)

        var formatter = SimpleDateFormat("EEEE")
        var strDay = formatter.format(strDate)
        var correctDay = strDay.toString()

        var correctOption = options[(0..3).random()]
        var optionSelect: TextView = findViewById<Button>(correctOption)
        optionSelect.text = correctDay
        optionSelect.setOnClickListener() {
                var layout = findViewById<RelativeLayout>(R.id.relLayout)
                layout.setBackgroundColor(Color.GREEN)
                counter++
                var Incrementer = findViewById<TextView>(R.id.increment)
                Incrementer.text = counter.toString()
                generateQuestionAndOptions()
            }
        days.remove(correctDay)
        for(i in days.indices){
            println(days[i])
        }
        options.remove(correctOption)


        var incOption = options[(0..2).random()]
        optionSelect = findViewById<Button>(incOption)
        var incorrectDay = days[(0..5).random()]
        optionSelect.text = incorrectDay
        days.remove(incorrectDay)
        options.remove(incOption)
        optionSelect.setOnClickListener() {
            var layout = findViewById<RelativeLayout>(R.id.relLayout)
            layout.setBackgroundColor(Color.RED)
            Toast.makeText(applicationContext, "YOU LOST", Toast.LENGTH_SHORT).show()
            val finalScore = counter

            val intent = Intent(this, ResultsPage::class.java)
            intent.putExtra("RESULT", finalScore.toString())
            startActivity(intent)

        }

        var incOption2 = options[(0..1).random()]
        optionSelect = findViewById<Button>(incOption2)
        var incorrectDay2 = days[(0..4).random()]
        optionSelect.text = incorrectDay2
        days.remove(incorrectDay2)
        options.remove(incOption2)
        optionSelect.setOnClickListener() {
            var layout = findViewById<RelativeLayout>(R.id.relLayout)
            layout.setBackgroundColor(Color.RED)
            Toast.makeText(applicationContext, "YOU LOST", Toast.LENGTH_SHORT).show()
            val finalScore = counter

            val intent = Intent(this, ResultsPage::class.java)
            intent.putExtra("RESULT", finalScore.toString())
            startActivity(intent)


        }

        var incOption3 = options[0]
        optionSelect = findViewById<Button>(incOption3)
        var incorrectDay3 = days[(0..3).random()]
        optionSelect.text = incorrectDay3
        days.remove(incorrectDay3)
        options.remove(incOption3)
        optionSelect.setOnClickListener() {
            var layout = findViewById<RelativeLayout>(R.id.relLayout)
            layout.setBackgroundColor(Color.RED)
            Toast.makeText(applicationContext, "YOU LOST", Toast.LENGTH_SHORT).show()
            val finalScore = counter

            val intent = Intent(this, ResultsPage::class.java)
            intent.putExtra("RESULT", finalScore.toString())
            startActivity(intent)
        }

        return correctOption
    }

}


