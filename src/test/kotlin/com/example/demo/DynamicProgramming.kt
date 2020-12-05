package com.example.demo

import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DynamicProgramming {

    @Test
    fun testFib() {

    }

    /**
     * MEMOIZATION
     *
     * hash map: keys will be args to function
     * value will be return value
     */

    fun fib(n: Long, memo: HashMap<Long, Long>): Long {
        if (memo.containsKey(n)) return memo[n]!!

        if (n <= 2) return 1

        memo[n] = fib(n - 1, memo) + fib(n - 2, memo)

        return memo[n]!!
    }
}