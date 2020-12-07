package com.example.demo.dynamicprogramming

import org.junit.Test

class CanSum {

    @Test
    fun testCanSum() {
        println(memoizedCanSum(7, longArrayOf(2,3))) // true
        println(memoizedCanSum(7, longArrayOf(5,3,4,7))) // true
        println(memoizedCanSum(7, longArrayOf(2,4))) // false
        println(memoizedCanSum(8, longArrayOf(2,3,5))) // true
        println(memoizedCanSum(300, longArrayOf(7,14))) // false
    }

    /**
     *
     * Function that takes in a targetSum & array of numbers as arguments...
     * Should return a boolean indicating whether it is possible to generate the targetSum
     * using numbers from the array.
     *
     * An array element can be used as many times as needed.
     *
     * Assumptions:
     * All input numbers are non-negative...
     *
     */

    /**
     *
     * Time Complexity: O(n^m)
     * Space Complexity: 0(m)
     *
     */
    fun canSum(targetSum: Long, numbers: LongArray): Boolean {
        if (targetSum == 0L) return true
        if (targetSum < 0L) return false

        for (i in numbers) {
            val remainder = targetSum - i
            if (canSum(remainder, numbers)) return true
        }

        return false
    }

    /**
     *
     * Time Complexity: O(mn) time...
     * Space Complexity: O(m)
     *
     */
    fun memoizedCanSum(targetSum: Long, numbers: LongArray, memo: HashMap<Long, Boolean> = hashMapOf()): Boolean {
        if (memo.containsKey(targetSum)) return memo[targetSum]!!
        if (targetSum == 0L) return true
        if (targetSum < 0L) return false

        for (i in numbers) {
            val remainder = targetSum - i
            if (canSum(remainder, numbers)) {
                memo[targetSum] = true
                return true
            }
        }

        memo[targetSum] = false
        return false
    }
}