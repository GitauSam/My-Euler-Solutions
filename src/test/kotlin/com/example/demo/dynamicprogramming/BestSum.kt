package com.example.demo.dynamicprogramming

import org.junit.Test

class BestSum<T> {

    /**
     *
     * Function that takes in a targetSum and an array of numbers as arguments.
     * It should return an array containing the shortest combination of numbers that
     * add up to exactly the targetSum.
     * If there is a tie, any of the combinations in the tie may be returned...
     *
     */

    /**
     *
     * m = targetSum, n = numbers.length
     * Time Complexity: O(n^m*m)
     * Space Complexity: 0(m^2)
     *
     */
    private fun bestSum(targetSum: Long, numbers: ArrayList<Long>): ArrayList<Long>? {
        if (targetSum == 0L) return arrayListOf()
        if (targetSum < 0) return null

        var shortestCombination: ArrayList<Long>? = null

        for (i in numbers) {
            val remainder = targetSum - i
            val remainderCombination = bestSum(remainder, numbers)
            remainderCombination?.let {
                remainderCombination.add(i)

                // check if combination is shorter than the current "shortest"
                if (shortestCombination == null || remainderCombination.size < shortestCombination!!.size) {
//                    println("previous shortest combination: $shortestCombination")
//                    println("evaluated result: $remainder")
//                    println("evaluated combination: $remainderCombination")
                    shortestCombination = remainderCombination
//                    println("resulting combination for target sum $targetSum: $shortestCombination")
//                    println("------------------------------------------------------------------")
                }
            }
        }

        return shortestCombination
    }

    /**
     *
     * Time Complexity: O(m^2*n)
     * Space Complexity: 0(m^2)
     *
     */
    private fun memoizedBestSum(targetSum: Long,
                                numbers: ArrayList<Long>,
                                memo: HashMap<Long, ArrayList<Long>?> = hashMapOf()): ArrayList<Long>? {

        if (memo.containsKey(targetSum)) return memo[targetSum]
        if (targetSum == 0L) return arrayListOf()
        if (targetSum < 0) return null

        var shortestCombination: ArrayList<Long>? = null

        for (i in numbers) {
            val remainder = targetSum - i
            val remainderCombination = memoizedBestSum(remainder, numbers, memo)
            remainderCombination?.let {
                remainderCombination.add(i)

                val combination = ArrayList<Long>()

                combination.addAll(remainderCombination)

                if (shortestCombination == null || combination.size < shortestCombination!!.size) {
                    shortestCombination = combination
                    memo[targetSum] = combination
                }

            }
        }

        println("Target Sum: $targetSum Hashed value: ${memo[targetSum]}")
        return shortestCombination
    }

    @Test
    fun testHowSum() {
        println(bestSum(7, arrayListOf(5, 3, 4, 7))) // [7]
        println(bestSum(8, arrayListOf(2, 3, 5))) // [3, 5]
        println(bestSum(8, arrayListOf(1, 4, 5))) // [4, 4]
        println(bestSum(100, arrayListOf(1, 2, 5, 25))) // [25, 25, 25, 25]
    }

    @Test
    fun testMemoizedHowSum() {
//        println(memoizedBestSum(7, arrayListOf(5, 3, 4, 7))) // [7]
//        println(memoizedBestSum(8, arrayListOf(2, 3, 5))) // [3, 5]
        println(memoizedBestSum(8, arrayListOf(1, 4, 5))) // [4, 4]
//        println(memoizedBestSum(100, arrayListOf(1, 2, 5, 25))) // [25, 25, 25, 25]

    }
}