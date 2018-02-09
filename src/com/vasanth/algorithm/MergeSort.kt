package com.vasanth.algorithm

// Merge Sort Algorithm

class MergeSort {

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[l .. m]
     * Second subarray is arr[m+1 .. r]
     */
    private fun merge(arr: Array<Int>, l: Int, m: Int, r: Int) {
        // Find sizes of two subarrays to be merged
        val n1 = m - l + 1
        val n2 = r - m

        // Create temp arrays
        val L = Array<Int>(n1, { i -> arr[l + i] })
        val R = Array<Int>(n2, { i -> arr[m + 1 + i] })

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        var i = 0
        var j = 0

        // Initial index of merged subarry array
        var k = l

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i]
                i++
            } else {
                arr[k] = R[j]
                j++
            }
            k++
        }

        // Copy remaining elements of L[] if any.
        while (i < n1) {
            arr[k] = L[i]
            i++
            k++
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j]
            j++
            k++
        }
    }

    /**
     * Main function that sorts arr[l .. r] using merge()
     */
    fun sort(arr: Array<Int>, l: Int, r: Int) {
        if (l < r) {
            // Find the middle point
            val m = (l + r) / 2

            // Sort first and second halves
            sort(arr, l, m)
            sort(arr, m + 1, r)

            // Merge the sorted halves
            merge(arr, l, m, r)
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val arr = arrayOf(12, 1, 124, 55, 2)

    val mergeSort = MergeSort()

    mergeSort.sort(arr, 0, (arr.size - 1))

    println("Sorted Array : ")
    for (item in arr) {
        print("${item} ")
    }
}