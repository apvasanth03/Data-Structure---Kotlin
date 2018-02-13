package com.vasanth.algorithm.searching

// Linear Search Algorithm

class LinearSearch {

    /**
     * This function returns index of element item in arr[]
     */
    fun search(arr: Array<Int>, item: Int): Int {
        for ((index, value) in arr.withIndex()) {
            if (value == item) {
                return index
            }
        }
        return -1
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val arr = arrayOf(12, 1, 124, 55, 2)
    val linearSearch = LinearSearch()

    val item = 124
    val result = linearSearch.search(arr, item)
    if(result == -1){
        println("Element not present")
    }else{
        println("Element found at index ${result}")
    }
}