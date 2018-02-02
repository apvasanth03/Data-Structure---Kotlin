package com.vasanth.datastructures.linkedlist

// DoublyLinkedList Data Structure

/**
 * DoublyLinkedList.
 */
class DoublyLinkedList {

    var head: Node? = null

    // DoublyLinkedList Node.
    class Node {
        var data: Int
        var next: Node? = null
        var prev: Node? = null

        constructor(data: Int) {
            this.data = data
        }
    }

    /**
     * INSERTING A NODE
     */

    /**
     * Adding a node at the front of the list.
     */
    fun push(newData: Int) {
        val newNode = Node(newData)

        newNode.next = head

        head?.prev = newNode

        head = newNode
    }

    /**
     * Given a node as prev_node, insert a new node after the given node.
     */
    fun insertAfter(prevNode: Node, newData: Int) {
        val newNode = Node(newData)

        newNode.next = prevNode.next

        prevNode.next = newNode

        newNode.prev = prevNode

        newNode.next?.prev = newNode
    }

    /**
     * Add a node at the end of the list.
     */
    fun append(newData: Int) {
        val newNode = Node(newData)

        // If the Linked List is empty, then make the new node as head
        if (head == null) {
            head = newNode
            return
        }

        // Else traverse till the last node
        var lastNode = head
        while (lastNode?.next != null) {
            lastNode = lastNode.next
        }

        lastNode?.next = newNode

        newNode.prev = lastNode
    }

    /**
     * DELETING A NODE
     */

    /**
     * Given a key, deletes the first occurrence of key in linked list.
     */
    fun deleteNode(key: Int) {
        if (head == null) {
            return
        }

        var temp = head

        // If head node itself holds the key to be deleted
        if (temp?.data == key) {
            head = temp.next
            head?.prev = null
            return
        }

        // Search for the key to be deleted
        while (temp != null && temp.data != key) {
            temp = temp.next
        }

        if (temp != null) {
            temp.prev?.next = temp.next
            temp.next?.prev = temp.prev
        }
    }

    /**
     * Given a reference (pointer to pointer) to the head of a list and a position, deletes the node at the given position.
     */

    fun deleteNodeAtGivenPosition(position: Int) {
        if (head == null) {
            return
        }

        var temp = head

        // If head needs to be removed
        if (position == 0) {
            head = temp?.next
            head?.prev = null
            return
        }

        // Find node to be deleted
        var i = 0
        while (temp != null && i < position) {
            temp = temp.next
            i++
        }

        if (temp != null) {
            temp.prev?.next = temp.next
            temp.next?.prev = temp.prev
        }
    }

    /**
     * TRAVERSING THE LIST
     */

    // This function prints contents of linked list starting from head
    fun printList() {
        var n = head
        while (n != null) {
            print("${n.data}  ")
            n = n.next
        }
    }

    /**
     * CALCULATE LENGTH.
     */

    /**
     * Returns count of nodes in linked list
     */
    fun getCount(): Int {
        var count = 0

        var temp = head
        while (temp != null) {
            count++
            temp = temp.next
        }

        return count
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val linkedList = DoublyLinkedList()

    linkedList.append(6)

    linkedList.push(7)

    linkedList.push(1)

    linkedList.append(4)

    linkedList.insertAfter(linkedList.head!!.next!!, 8)

    println("\nCreated Linked list is: ")
    linkedList.printList();

    linkedList.deleteNode(8)

    println("\nLinked List after Deletion of key 8:")
    linkedList.printList()

    linkedList.deleteNodeAtGivenPosition(1)

    println("\nLinked List after Deletion at position 1:")
    linkedList.printList()

    println("\nCount of nodes is " + linkedList.getCount());
}