package com.vasanth.algorithm

// Bubble Sort Algorithm

class BubbleSort {

    fun sort(arr: Array<Int>) {
        val n = arr.size

        var i = 0
        while (i < n - 1) {
            var j = 0
            while (j < n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
                j++
            }
            i++
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val arr = arrayOf(12, 1, 124, 55, 2)

    val bubbleSort = BubbleSort()

    val sortedArr = bubbleSort.sort(arr)

    println("Sorted Array : ")
    for (item in arr) {
        print("${item} ")
    }
}