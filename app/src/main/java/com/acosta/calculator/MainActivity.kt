package com.acosta.calculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val firstNum = findViewById<EditText>(R.id.first_number_et)
        val secondNum = findViewById<EditText>(R.id.second_number_et)
        val addButton = findViewById<Button>(R.id.add_button)
        val subtractButton = findViewById<Button>(R.id.subtract_button)
        val divideButton = findViewById<Button>(R.id.divide_button)
        val multiplyButton = findViewById<Button>(R.id.multiply_button)
        val answerTv = findViewById<TextView>(R.id.answer_tv)

        val decimalFormat = DecimalFormat("#.##")

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    val str = s.toString()
                    if (str.isNotEmpty()) {
                        try {
                            val value = str.toDouble()
                            val formattedValue = decimalFormat.format(value)
                            if (str != formattedValue) {
                                s.replace(0, s.length, formattedValue)
                            }
                        } catch (e: NumberFormatException) {
                            s.clear()
                        }
                    }
                }
            }
        }

        firstNum.addTextChangedListener(textWatcher)
        secondNum.addTextChangedListener(textWatcher)

        addButton.setOnClickListener {
            val num1 = firstNum.text.toString().toDoubleOrNull()
            val num2 = secondNum.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 + num2
                answerTv.text = decimalFormat.format(result)
            }
        }

        subtractButton.setOnClickListener {
            val num1 = firstNum.text.toString().toDoubleOrNull()
            val num2 = secondNum.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 - num2
                answerTv.text = decimalFormat.format(result)
            }
        }

        multiplyButton.setOnClickListener {
            val num1 = firstNum.text.toString().toDoubleOrNull()
            val num2 = secondNum.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 * num2
                answerTv.text = decimalFormat.format(result)
            }
        }

        divideButton.setOnClickListener {
            val num1 = firstNum.text.toString().toDoubleOrNull()
            val num2 = secondNum.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    val result = num1 / num2
                    answerTv.text = decimalFormat.format(result)
                } else {
                    answerTv.text = "Error: Division by zero"
                }
            }
        }
    }
}