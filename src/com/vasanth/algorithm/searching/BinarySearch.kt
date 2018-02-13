package com.vasanth.algorithm.searching

// Binary Search Algorithm

class BinarySearch {

    /**
     * Returns index of item if it is present in arr[l .. r], else return -1
     */
    fun search(arr: Array<Int>, l: Int, r: Int, item: Int): Int {
        if (r >= l) {
            val mid = l + (r - l) / 2

            // If the element is present at the middle itself
            if (arr[mid] == item) {
                return mid
            }

            // If element is smaller than mid, then it can only be present in left subarray
            if (item < arr[mid]) {
                return search(arr, l, mid - 1, item)
            }

            // Else the element can only be present in right subarray
            else {
                return search(arr, mid + 1, r, item)
            }

        }

        // We reach here when element is not present in array
        return -1
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val arr = arrayOf(12, 1, 124, 55, 2)
    val binarySearch = BinarySearch()

    val item = 124
    val result = binarySearch.search(arr, 0, (arr.size - 1), item)
    if (result == -1) {
        println("Element not present")
    } else {
        println("Element found at index ${result}")
    }
}