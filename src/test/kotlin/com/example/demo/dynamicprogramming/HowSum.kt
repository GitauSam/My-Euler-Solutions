package com.example.demo.dynamicprogramming

import org.junit.Test

class HowSum {
    /**
     *
     * Function that takes in a targetSum and an array of numbers as arguments.
     * Function returns an array containing any combination of elements that add up
     * to the targetSum. If there is no combination, then returns null.
     *
     * If there are multiple possible combinations, then return a single one.
     *
     **/

    /**
     *
     * m = targetSum, n = numbers.size
     * Time Complexity: O(n^m * m)
     * Space Complexity: O(m)
     *
     */
    private fun howSum(targetSum: Long, numbers: ArrayList<Long>): ArrayList<Long>? {
        if (targetSum == 0L) return arrayListOf()
        if (targetSum < 0) return null

        for (i in numbers) {
            val remainder = targetSum - i
            val remainderResult = howSum(remainder, numbers)
            remainderResult?.let {
                it.add(i)
                return it
            }
        }

        return null
    }

    /**
     *
     * Time Complexity: O(n*m^2)
     * m => no of keys in memo object, m => size of array being stored as value...
     * Space COmplexity: O(m*m)
     *
     */
    private fun memoizedHowSum(targetSum: Long, numbers: ArrayList<Long>, memo: HashMap<Long, ArrayList<Long>?> = hashMapOf()): ArrayList<Long>? {
        if (memo.containsKey(targetSum)) return memo[targetSum]
        if (targetSum == 0L) return arrayListOf()
        if (targetSum < 0) return null

        for (i in numbers) {
            val remainder = targetSum - i
            val remainderResult = memoizedHowSum(remainder, numbers, memo)
            remainderResult?.let {
                it.add(i)
                memo[targetSum] = it
                return it
            }
        }

        memo[targetSum] = null
        return null
    }

    @Test
    fun testHowSum() {
        println(howSum(7, arrayListOf(2, 3))) // [3, 2, 2]
        println(howSum(7, arrayListOf(5, 3, 4, 7))) // [4, 3]
        println(howSum(7, arrayListOf(2, 4))) // null
        println(howSum(8, arrayListOf(2, 3, 5))) // [2, 2, 2, 2]
        println(howSum(300, arrayListOf(7, 14))) // null
    }

    @Test
    fun testMemoizedHowSum() {
        println(memoizedHowSum(7, arrayListOf(2, 3))) // [3, 2, 2]
        println(memoizedHowSum(7, arrayListOf(5, 3, 4, 7))) // [4, 3]
        println(memoizedHowSum(7, arrayListOf(2, 4))) // null
        println(memoizedHowSum(8, arrayListOf(2, 3, 5))) // [2, 2, 2, 2]
        println(memoizedHowSum(300, arrayListOf(7, 14))) // null
    }

}