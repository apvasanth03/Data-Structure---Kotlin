package com.vasanth.datastructures.queue

// Queue Data Structure - Implemented using Array.

class QueueUsingLinkedList {

    var front: Node? = null
    var rear: Node? = null

    // LinkedList Node.
    class Node {
        var data: Int
        var next: Node?

        constructor(data: Int) {
            this.data = data
            next = null
        }
    }

    /**
     * Queue is empty when front is null
     */
    fun isEmpty(): Boolean {
        return (front == null)
    }

    /**
     * Method to add an item to the queue.
     */
    fun enqueue(item: Int): Boolean {
        val newNode = Node(item)

        // If queue is empty, then new node is front and rear both
        if (isEmpty()) {
            front = newNode
            rear = newNode
        }
        // Add the new node at the end of queue and change rear
        else {
            rear?.next = newNode
            rear = newNode
        }
        return true
    }

    /**
     * Method to remove an item from queue.
     */
    fun dequeue(): Int? {
        if (isEmpty()) {
            println("Queue Underflow")
            return null
        } else {
            // Store previous front and move front one node ahead
            val item = front?.data
            front = front?.next

            // If front becomes NULL, then change rear also as NULL
            if (front == null) {
                rear = null
            }
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
            val item = front?.data
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
            val item = rear?.data
            return item
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val queue = QueueUsingLinkedList()

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    queue.enqueue(40)

    println("${queue.dequeue()} dequeued from queue\n");

    println("Front item is ${queue.front()}");

    println("Rear item is ${queue.rear()}");
}