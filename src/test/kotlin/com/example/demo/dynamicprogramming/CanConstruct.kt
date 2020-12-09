package com.example.demo.dynamicprogramming

import org.junit.Test

class CanConstruct {

    /**
     *
     * Function that accepts a target string and an array of strings.
     * It should return a boolean indicating whether or not the target string can be constructed
     * by concatenating elements of the string array.
     * String elements may be reused as many times as needed.
     *
     */

    /**
     * m = target.length
     * n = wordBank.size
     *
     * m = height of resulting tree
     * n = branching factor per tree level
     *
     * Height of tree determines maximum no of stack frames before execution is bottomed out
     *
     * Time complexity: O(n^m*m) [Also takes into consideration the substring operation]
     * Space complexity: O(m^2) [Also takes into consideration the substring operation]
     *
     */
    private fun canConstruct(target: String, wordBank: Array<String>): Boolean {
        if (target == "") return true

        for (prefix in wordBank) {
            if (target.indexOf(prefix) == 0) {
                if (canConstruct(target.substringAfter(prefix), wordBank)) return true
            }
        }

        return false
    }

    /**
     *
     * Time complexity: O(n*m^2)
     * Space complexity: O(m^2)
     *
     */
    private fun memoizedCanConstruct(target: String,
                                     wordBank: Array<String>,
                                     memo: HashMap<String, Boolean> = hashMapOf()): Boolean {
        if (memo.containsKey(target)) return memo[target]!!
        if (target == "") return true

        for (prefix in wordBank) {
            if (target.indexOf(prefix) == 0) {
                if (memoizedCanConstruct(target.substringAfter(prefix), wordBank, memo)) {
                    memo[target] = true
                    return true
                }
            }
        }

        memo[target] = false
        return false
    }

    @Test
    fun testCanConstruct() {
        println(canConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"))) // true
        println(canConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))) // false
        println(canConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"))) // true
        println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("e","eee","eeeeee","eeeeeeeeeee"))) // false
    }

    @Test
    fun testMemoizedCanConstruct() {
        println(memoizedCanConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"))) // true
        println(memoizedCanConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))) // false
        println(memoizedCanConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"))) // true
        println(memoizedCanConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("e","eee","eeeeee","eeeeeeeeeee"))) // false
    }
}