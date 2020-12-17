package com.example.demo.projecteuler

import org.junit.Test
import kotlin.math.abs
import kotlin.math.pow

class DifferenceOfSquareOfSumAndSumOfSquares {

    @Test
    fun differenceOfSumOfSquaresAndSquareOfSum() {
        val squareOfSum: Double = (100.0 * (100 + 1)/2).pow(2)

        var sumOfSquares = 0.0

        for (i in 1..100) {
            sumOfSquares += i*i
        }

        println(abs(sumOfSquares - squareOfSum))
    }
}