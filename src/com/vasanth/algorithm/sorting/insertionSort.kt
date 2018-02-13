package com.vasanth.algorithm.sorting

// Insertion Sort Algorithm

class InsertionSort {

    fun sort(arr: Array<Int>) {
        val n = arr.size

        for (i in 1 until n) {
            val key = arr[i]
            var j = i - 1
            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j--
            }
            arr[j + 1] = key
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val arr = arrayOf(12, 1, 124, 55, 2)

    val insertionSort = InsertionSort()

    insertionSort.sort(arr)

    println("Sorted Array : ")
    for (item in arr) {
        print("${item} ")
    }
}