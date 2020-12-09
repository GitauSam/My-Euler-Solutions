package com.example.demo.dynamicprogramming

import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FibMemoization {

    @Test
    fun testFib() {
        println(fib(6))
        println(fib(7))
        println(fib(8))
        println(fib(50))
    }

    /**
     *
     * UNMEMOIZED
     *
     * Time complexity: O(2^n)
     * Space complexity: O(n)
     *
     * MEMOIZATION
     *
     * hash map: keys will be args to function
     * value will be return value
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     */

    fun fib(n: Long, memo: HashMap<Long, Long> = hashMapOf()): Long {
        if (memo.containsKey(n)) return memo[n]!!

        if (n <= 2) return 1

        memo[n] = fib(n - 1, memo) + fib(n - 2, memo)

        return memo[n]!!
    }
}