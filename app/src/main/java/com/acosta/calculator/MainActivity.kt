package com.acosta.calculator

import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNum = findViewById<EditText>(R.id.first_number_et)
        val secondNum = findViewById<EditText>(R.id.second_number_et)
        val addButton = findViewById<Button>(R.id.add_button)
        val subtractButton = findViewById<Button>(R.id.subtract_button)
        val divideButton = findViewById<Button>(R.id.divide_button)
        val multiplyButton = findViewById<Button>(R.id.multiply_button)
        val answerTv = findViewById<TextView>(R.id.answer_tv)

        // Limit input to 2 decimal places
        firstNum.filters = arrayOf(DecimalDigitsInputFilter(5, 2))
        secondNum.filters = arrayOf(DecimalDigitsInputFilter(5, 2))

        addButton.setOnClickListener {
            val num1 = firstNum.text.toString().toDoubleOrNull()
            val num2 = secondNum.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 + num2
                answerTv.text = String.format("%.2f", result)
            }
        }

        subtractButton.setOnClickListener {
            val num1 = firstNum.text.toString().toDoubleOrNull()
            val num2 = secondNum.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 - num2
                answerTv.text = String.format("%.2f", result)
            }
        }

        multiplyButton.setOnClickListener {
            val num1 = firstNum.text.toString().toDoubleOrNull()
            val num2 = secondNum.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 * num2
                answerTv.text = String.format("%.2f", result)
            }
        }

        divideButton.setOnClickListener {
            val num1 = firstNum.text.toString().toDoubleOrNull()
            val num2 = secondNum.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    val result = num1 / num2
                    answerTv.text = String.format("%.2f", result)
                } else {
                    answerTv.text = "Error: Division by zero"
                }
            }
        }
    }
}

class DecimalDigitsInputFilter(digitsBeforeZero: Int, digitsAfterZero: Int) : InputFilter {
    private val pattern = Regex("[0-9]{0,$digitsBeforeZero}+((\\.[0-9]{0,$digitsAfterZero})?)||(\\.)?")

    override fun filter(
        source: CharSequence?, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int
    ): CharSequence? {
        val input = dest?.toString()?.substring(0, dstart) + source?.toString() + dest?.toString()?.substring(dend)
        return if (input.matches(pattern)) null else ""
    }
}
