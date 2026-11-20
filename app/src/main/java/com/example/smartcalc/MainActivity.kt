package com.example.smartcalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smartcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val calculatorEngine = MotorCalculadora()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNumberListeners()
        setupOperatorListeners()
        setupActionListeners()
    }

    private fun setupNumberListeners() {
        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6, binding.btn7,
            binding.btn8, binding.btn9
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                calculatorEngine.appendNumber(button.text.toString())
                updateUI()
            }
        }

        binding.btnDecimal.setOnClickListener {
            calculatorEngine.appendDecimal()
            updateUI()
        }
    }

    private fun setupOperatorListeners() {
        binding.btnPlus.setOnClickListener { onOperatorClick("+") }
        binding.btnMinus.setOnClickListener { onOperatorClick("-") }
        binding.btnMultiply.setOnClickListener { onOperatorClick("×") }
        binding.btnDivide.setOnClickListener { onOperatorClick("÷") }
    }

    private fun onOperatorClick(operator: String) {
        calculatorEngine.setOperator(operator)
        updateUI()
    }

    private fun setupActionListeners() {
        binding.btnClear.setOnClickListener {
            calculatorEngine.clear()
            updateUI()
        }

        binding.btnDel.setOnClickListener {
            calculatorEngine.deleteLast()
            updateUI()
        }

        binding.btnSign.setOnClickListener {
            calculatorEngine.toggleSign()
            updateUI()
        }

        binding.btnEquals.setOnClickListener {
            calculatorEngine.calculate()
            updateUI()
        }
    }

    private fun updateUI() {
        binding.tvResult.text = calculatorEngine.currentInput
        binding.tvExpression.text = calculatorEngine.expression
    }
}