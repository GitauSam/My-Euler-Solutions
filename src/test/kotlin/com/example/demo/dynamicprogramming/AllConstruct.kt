package com.example.demo.dynamicprogramming

class AllConstruct {

    /**
     *
     * Function that accepts a target string and an array of strings
     * Function should return a 2d array containing all the ways that
     * the target can be constructed by concatenating elements of the
     * array.
     *
     * Elements may be reused.
     *
     */

    fun allConstruct(target: String,
                     wordBank: Array<String>): ArrayList<ArrayList<String>>{
        if (target == "") return arrayListOf(arrayListOf<String>())

        for (word in wordBank) {
            if (target.indexOf(word) == 0) {
                val suffix = target.substringAfter(word)
                val suffixWays = allConstruct(suffix, wordBank)
                val targetWays = arrayListOf<ArrayList<String>>()
                val count = 0
                suffixWays.forEach {
                    targetWays[count] = it
                    targetWays[count][0] = word
                }
            }
        }
    }
}