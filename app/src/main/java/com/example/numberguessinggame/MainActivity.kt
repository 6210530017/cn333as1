package com.example.numberguessinggame

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var ask:TextView
    lateinit var editText:EditText
    lateinit var hint:TextView
    lateinit var button:Button

    var random: Int = Random.nextInt(1, 1000)
    var count_click: Int = 0
    var in_game: Boolean = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ask = findViewById(R.id.Ask)
        editText = findViewById(R.id.editText)
        hint = findViewById(R.id.Hint)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            if (in_game) {
                if (editText.text.isNotEmpty()) {
                    hint.setTextColor(Color.GRAY)

                    val number: Int = editText.text.toString().toInt()

                    if (number < random) {
                        hint.text = "Hint: It's higher!"
                        editText.text.clear()
                        count_click++
                    } else if (number > random) {
                        hint.text = "Hint: It's lower!"
                        editText.text.clear()
                        count_click++
                    } else {
                        ask.setTextColor(Color.rgb(41,168,30))
                        ask.text = "Congratulation!, your number is right!, You use: $count_click time(s)."
                        hint.text = "Click play again to the new game"
                        button.setText("Play again")
                        editText.text.clear()
                        in_game = false
                    }
                } else {
                    hint.text = "Please enter number"
                    hint.setTextColor(Color.RED)
                }
            } else {
                reset()
            }
        }
    }
    fun reset() {
        random = Random.nextInt(1, 1000)
        ask.setTextColor(Color.BLACK)
        ask.text = "Try to guess thee number I'm thinking of from 1 - 1000!"
        button.setText("Enter")
        hint.text = ""
        editText.text.clear()
        in_game = true
        count_click = 0
    }
}