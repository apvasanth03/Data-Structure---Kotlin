package com.vasanth.datastructures.other.hashing

// Program to demonstrate implementation of our own hash table with chaining for collision detection
// Refer - https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/

class HashTable<K : Any, V : Any> {

    // bucketArray is used to store array of chains
    var bucketArray: Array<HashNode?>

    // Current capacity of bucket
    var numBucket: Int

    // Current size of hashTable
    var size: Int

    // A node of chains.
    inner class HashNode {

        val key: K
        var value: V
        var next: HashNode?

        constructor(key: K, value: V) {
            this.key = key
            this.value = value
            this.next = null
        }
    }

    constructor() {
        numBucket = 10
        size = 0
        bucketArray = arrayOfNulls(numBucket)
    }

    /**
     * This implements hash function to find index for a key.
     */
    private fun getBucketIndex(key: K): Int {
        val hashCode = key.hashCode()
        val index = hashCode % numBucket
        return index
    }

    /**
     * Method to get size of the HashTable
     */
    fun size(): Int {
        return size
    }

    /**
     * Method to check if HashTable is empty or not.
     */
    fun isEmpty(): Boolean {
        return (size == 0)
    }

    /**
     * Adds a key value pair to hash.
     */
    fun add(key: K, value: V) {
        // Find head of chain for given key
        val bucketIndex = getBucketIndex(key)
        var head = bucketArray[bucketIndex]

        // Check if key is already present
        while (head != null) {
            if (head.key == key) {
                head.value = value
                return
            }
            head = head.next
        }

        // Insert key in chain
        size++
        head = bucketArray[bucketIndex]
        val newNode = HashNode(key, value)
        newNode.next = head
        bucketArray[bucketIndex] = newNode

        // If load factor goes beyond threshold, then  double hash table size
        if ((size / numBucket) >= 0.7) {
            val temp = bucketArray
            numBucket = numBucket * 2
            bucketArray = arrayOfNulls(numBucket)
            size = 0

            for (i in temp.indices) {
                var head = temp[i]
                while (head != null) {
                    add(head.key, head.value)
                    head = head.next
                }
            }
        }
    }

    /**
     * Method to remove a given key.
     */
    fun remove(key: K): V? {
        // Apply hash function to find index for given key
        val bucketIndex = getBucketIndex(key)

        // Get head of chain
        var head = bucketArray[bucketIndex]

        // Search for key in its chain
        var prev: HashNode? = null
        while (head != null) {
            if (head.key == key) {
                break
            }
            prev = head
            head = head.next
        }

        // If key was not there
        if (head == null) {
            return null
        }

        // Reduce size
        size--

        // Remove key
        if (prev != null) {
            prev.next = head.next
        } else {
            bucketArray[bucketIndex] = head.next
        }

        return head.value
    }

    /**
     * Returns value for a key.
     */
    fun get(key: K): V? {
        // Find head of chain for given key
        val bucketIndex = getBucketIndex(key)
        var head = bucketArray[bucketIndex]

        // Search key in chain
        while (head != null) {
            if (head.key == key) {
                break
            }
            head = head.next
        }

        return head?.value
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val hashTable = HashTable<String, Int>()
    hashTable.add("this", 1);
    hashTable.add("coder", 2);
    hashTable.add("this", 4);
    hashTable.add("hi", 5);
    println(hashTable.size());
    println(hashTable.remove("this"));
    println(hashTable.remove("this"));
    println(hashTable.size());
    println(hashTable.isEmpty());
}