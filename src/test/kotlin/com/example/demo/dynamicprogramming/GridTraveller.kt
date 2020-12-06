package com.example.demo.dynamicprogramming

import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GridTraveller {

    @Test
    fun testGridTraveller() {
        println(gridTraveller(1,1)) // 1
        println(gridTraveller(2,3)) // 3
        println(gridTraveller(3,2)) // 3
        println(gridTraveller(3,3)) // 6
        println(gridTraveller(18, 18)) //2333606220
    }

    /**
     *
     * Inputs to consider: m,n
     * Time Complexity: 0(2^n+m)
     * Space Complexity: O(n+m)
     *
     */
    fun gridTraveller(m: Long, n: Long): Long {
        if (m == 1L && n == 1L) return 1

        if (m == 0L || n == 0L) return 0

        return gridTraveller(m-1, n) + gridTraveller(m,n-1)
    }

    /**
     *
     * Time Complexity: O(mn)
     * Space Complexity: O(n+m)
     *
     */
    fun memoizedGridTraveller(m: Long, n: Long, memo: HashMap<String, Long> = hashMapOf()): Long {
        if (memo.containsKey("$m,$n")) return memo["$m,$n"]!!

        if (m == 1L && n == 1L) return 1

        if (m == 0L || n == 0L) return 0

        memo["$m,$n"] = memoizedGridTraveller(m-1, n, memo) + memoizedGridTraveller(m,n-1, memo)

        return memo["$m,$n"]!!
    }
}