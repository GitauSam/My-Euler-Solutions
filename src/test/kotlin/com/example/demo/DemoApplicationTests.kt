package com.example.demo

import org.junit.Test
import kotlin.math.sqrt

class DemoApplicationTests {

    // Problem 12
    @Test
    fun getTriangleNoWithOver500Factors() {
        var currentTriangleNo = 0
        var triangleNoSequence = 1.0
        var factors = 0

        while (factors < 500) {

            factors = 0

            currentTriangleNo = (triangleNoSequence*((triangleNoSequence+1)/2)).toInt()

            for (i in 1..sqrt(currentTriangleNo.toDouble()).toInt()) {
                if (currentTriangleNo%i == 0) factors += 2
            }

            println("Triangle number ${triangleNoSequence.toInt()}: $currentTriangleNo has $factors factors")

            triangleNoSequence++
        }

        println("Triangle Number:  $currentTriangleNo")
    }

}
