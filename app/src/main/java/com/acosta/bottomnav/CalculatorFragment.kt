package com.acosta.bottomnav

import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        val firstNum = view.findViewById<EditText>(R.id.first_number_et)
        val secondNum = view.findViewById<EditText>(R.id.second_number_et)
        val addButton = view.findViewById<Button>(R.id.add_button)
        val subtractButton = view.findViewById<Button>(R.id.subtract_button)
        val divideButton = view.findViewById<Button>(R.id.divide_button)
        val multiplyButton = view.findViewById<Button>(R.id.multiply_button)
        val answerTv = view.findViewById<TextView>(R.id.answer_tv)

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

        return view
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
}
