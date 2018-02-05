package com.vasanth.datastructures.stack

// Stack Data Structure - Implemented using LinkedList.

class StackUsingLinkedList {

    var top: Node? = null

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
     * Returns true if stack is empty, else false.
     */
    fun isEmpty(): Boolean {
        return (top == null)
    }

    /**
     * Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
     */
    fun push(item: Int): Boolean {
        val newNode = Node(item)

        newNode.next = top

        top = newNode

        return true
    }

    /**
     * Removes an item from the stack. The items are popped in the reversed order in which they are pushed.
     * If the stack is empty, then it is said to be an Underflow condition.
     */
    fun pop(): Int? {
        if (isEmpty()) {
            println("Stack Underflow")
            return null
        } else {
            val item = top?.data
            top = top?.next
            top?.next = null
            return item
        }
    }

    /**
     * Returns top element of stack.
     */
    fun peek(): Int? {
        if (isEmpty()) {
            println("Stack Underflow")
            return null
        } else {
            val item = top?.data
            return item
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val stack = StackUsingLinkedList()

    stack.push(10);
    stack.push(20);
    stack.push(30);
    println("${stack.pop()} Popped from stack");
    println("${stack.peek()} Top element of stack")
}