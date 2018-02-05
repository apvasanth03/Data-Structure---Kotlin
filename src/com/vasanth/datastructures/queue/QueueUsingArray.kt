package com.vasanth.datastructures.queue

// Queue Data Structure - Implemented using Array.

class QueueUsingArray {

    val CAPACITY = 100
    var front: Int
    var rear: Int
    var size: Int
    val queue: Array<Int?>

    constructor() {
        queue = arrayOfNulls<Int>(CAPACITY)
        front = 0
        rear = CAPACITY - 1
        size = 0
    }

    /**
     * Queue is empty when size is 0.
     */
    fun isEmpty(): Boolean {
        return (size == 0)
    }

    /**
     * Queue is full when size becomes equal to the capacity.
     */
    fun isFull(): Boolean {
        return (size == CAPACITY)
    }

    /**
     * Method to add an item to the queue. It changes rear and size.
     */
    fun enqueue(item: Int): Boolean {
        if (isFull()) {
            println("Queue Overflow")
            return false
        } else {
            rear = (rear + 1) % CAPACITY
            queue[rear] = item
            size++
            return true
        }
    }

    /**
     * Method to remove an item from queue. It changes front and size.
     */
    fun dequeue(): Int? {
        if (isEmpty()) {
            println("Queue Underflow")
            return null
        } else {
            val item = queue[front]
            front = (front + 1) % CAPACITY
            size--
            return item
        }
    }

    /**
     * Method to get front of queue.
     */
    fun front(): Int? {
        if (isEmpty()) {
            println("Queue Underflow")
            return null
        } else {
            val item = queue[front]
            return item
        }
    }

    /**
     * Method to get rear of queue.
     */
    fun rear(): Int? {
        if (isEmpty()) {
            println("Queue Underflow")
            return null
        } else {
            val item = queue[rear]
            return item
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val queue = QueueUsingArray()

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    queue.enqueue(40)

    println("${queue.dequeue()} dequeued from queue\n");

    println("Front item is ${queue.front()}");

    println("Rear item is ${queue.rear()}");
}