package com.vasanth.algorithm

// Selection Sort Algorithm.

class SelectionSort {

    fun sort(arr: Array<Int>) {
        val n = arr.size

        var i = 0
        while (i < n - 1) {
            var minIndex = i

            var j = i + 1
            while (j < n) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
                j++
            }

            val temp = arr[minIndex]
            arr[minIndex] = arr[i]
            arr[i] = temp
            i++
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val arr = arrayOf(12, 1, 124, 55, 2)

    val selectionSort = SelectionSort()

    selectionSort.sort(arr)

    println("Sorted Array : ")
    for (item in arr) {
        print("${item} ")
    }
}