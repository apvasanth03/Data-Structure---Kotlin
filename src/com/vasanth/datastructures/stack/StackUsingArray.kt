package com.vasanth.datastructures.stack

// Stack Data Structure - Implemented using Array.

class StackUsingArray {

    val MAX = 100
    var top: Int
    val stack = arrayOfNulls<Int>(MAX)

    constructor() {
        this.top = -1
    }

    /**
     * Returns true if stack is empty, else false.
     */
    fun isEmpty(): Boolean {
        return (top < 0)
    }

    /**
     * Returns true if stack is full, else false.
     */
    fun isFull(): Boolean {
        return (top >= MAX)
    }

    /**
     * Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
     */
    fun push(item: Int): Boolean {
        if (isFull()) {
            println("Stack Overflow")
            return false
        } else {
            stack[++top] = item
            return true
        }
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
            val item = stack[top--]
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
            val item = stack[top]
            return item
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val stack = StackUsingArray()

    stack.push(10);
    stack.push(20);
    stack.push(30);
    println("${stack.pop()} Popped from stack");
    println("${stack.peek()} Top element of stack")
}