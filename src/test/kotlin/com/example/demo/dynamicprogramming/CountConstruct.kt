package com.example.demo.dynamicprogramming

import org.junit.Test

class CountConstruct {

    /**
     *
     * Function that accepts a target string and an array of strings.
     * Returns number of ways the target string can be constructed
     * by concatenating elements of the array.
     * Elements may ne reused as many times as needed.
     *
     */

    /**
     *
     * m = target.length
     * n = wordBank.length
     *
     * Time Complexity: O(n^m * m)
     * Space Complexity: O(m^2)
     *
     */
    fun countConstruct(target: String, wordBank: Array<String>): Int {
        if (target == "") return 1;

        var total = 0

        for (word in wordBank) {
            if (target.indexOf(word) == 0) {
                val numWayForRest = countConstruct(target.substringAfter(word), wordBank)
                total += numWayForRest
            }
        }

        return total
    }

    /**
     *
     * n = target.length
     * m = wordBank.length
     *
     * Time Complexity: O(n * m^2)
     * Space Complexity: O(m^2)
     *
     */
    fun memoizedCountConstruct(target: String,
                               wordBank: Array<String>,
                                memo: HashMap<String, Long> = hashMapOf()): Long {
        if (memo.containsKey(target)) return memo[target]!!
        if (target == "") return 1;

        var total: Long = 0

        for (word in wordBank) {
            if (target.indexOf(word) == 0) {
                val numWayForRest = memoizedCountConstruct(target.substringAfter(word),
                        wordBank,
                        memo)
                total += numWayForRest
            }
        }

        memo[target] = total
        return total
    }

    @Test
    fun testCountConstruct() {
        println(memoizedCountConstruct("goodlife", arrayOf("g", "o", "dli", "life", "fe", "good"))) // 2
        println(memoizedCountConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))) // 0
        println(memoizedCountConstruct("potato", arrayOf("a", "p", "otat", "ot", "o", "t"))) // 3
        println(memoizedCountConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("e","eee","eeeeee","eeeeeeeeeee"))) // 0
    }
}