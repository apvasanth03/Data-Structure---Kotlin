package com.vasanth.algorithm

// Quick Sort Algorithm

class QuickSort {

    /**
     * This function takes last element as pivot,
     * places the pivot element at its correct position in sorted array,
     * and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
     */
    private fun partition(arr: Array<Int>, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = (low - 1) // index of smaller element

        for (j in low until high) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++

                // swap arr[i] and arr[j]
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp

        return (i + 1)
    }

    /**
     * The main function that implements QuickSort()
     * arr[] --> Array to be sorted,
     * low  --> Starting index,
     * high  --> Ending index
     */
    fun sort(arr: Array<Int>, low: Int, high: Int) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            val pi = partition(arr, low, high)

            // Recursively sort elements before partition and after partition.
            sort(arr, low, (pi - 1))
            sort(arr, (pi + 1), high)
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val arr = arrayOf(12, 1, 124, 55, 2)

    val quickSort = QuickSort()

    quickSort.sort(arr, 0, (arr.size - 1))

    println("Sorted Array : ")
    for (item in arr) {
        print("${item} ")
    }
}