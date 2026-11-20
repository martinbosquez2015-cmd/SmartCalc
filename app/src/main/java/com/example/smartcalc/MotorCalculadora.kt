package com.example.smartcalc

class MotorCalculadora {
    var currentInput: String = "0"
        private set
    var expression: String = ""
        private set
    var hasError: Boolean = false
        private set

    private var firstOperand: Double = 0.0
    private var lastOperator: String = ""
    private var isNewOperation: Boolean = true

    fun appendNumber(number: String) {
        if (hasError) clear()
        if (isNewOperation) {
            currentInput = number
            isNewOperation = false
        } else {
            if (currentInput == "0" && number != ".") {
                currentInput = number
            } else {
                currentInput += number
            }
        }
    }

    fun appendDecimal() {
        if (hasError) clear()
        if (isNewOperation) {
            currentInput = "0."
            isNewOperation = false
        } else if (!currentInput.contains(".")) {
            // Control para evitar múltiples puntos decimales en una misma cifra
            currentInput += "."
        }
    }

    fun setOperator(operator: String) {
        if (hasError) clear()
        try {
            firstOperand = currentInput.toDouble()
        } catch (e: NumberFormatException) {
            firstOperand = 0.0
        }
        lastOperator = operator
        expression = "$currentInput $operator"
        isNewOperation = true
    }

    fun calculate(): String {
        if (hasError || lastOperator.isEmpty()) return currentInput

        val secondOperand = try {
            currentInput.toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }

        expression = "$firstOperand $lastOperator $secondOperand ="

        val result = when (lastOperator) {
            "+" -> firstOperand + secondOperand
            "-" -> firstOperand - secondOperand
            "×" -> firstOperand * secondOperand
            "÷" -> {
                if (secondOperand == 0.0) {
                    hasError = true
                    return "Error: Div por 0"
                } else {
                    firstOperand / secondOperand
                }
            }
            else -> secondOperand
        }

        currentInput = formatResult(result)
        isNewOperation = true
        lastOperator = ""
        return currentInput
    }

    fun toggleSign() {
        if (hasError) return
        currentInput = if (currentInput.startsWith("-")) {
            currentInput.substring(1)
        } else if (currentInput != "0") {
            "-$currentInput"
        } else {
            "0"
        }
    }

    fun deleteLast() {
        if (hasError) {
            clear()
            return
        }
        if (currentInput.length > 1) {
            currentInput = currentInput.dropLast(1)
        } else {
            currentInput = "0"
        }
    }

    fun clear() {
        currentInput = "0"
        expression = ""
        lastOperator = ""
        firstOperand = 0.0
        isNewOperation = true
        hasError = false
    }

    private fun formatResult(value: Double): String {
        return if (value == value.toLong().toDouble()) {
            value.toLong().toString()
        } else {
            value.toString()
        }
    }
}