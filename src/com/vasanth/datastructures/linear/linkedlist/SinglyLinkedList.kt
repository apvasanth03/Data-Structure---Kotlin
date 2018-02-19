package com.vasanth.datastructures.linear.linkedlist

// SinglyLinkedList Data Structure

/**
 * SinglyLinkedList.
 */
class SinglyLinkedList {

    var head: Node? = null

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
     * INSERTING A NODE
     */

    /**
     * This function is in LinkedList class. Inserts a new Node at front of the list.
     */
    fun push(newData: Int) {
        val newNode = Node(newData)

        newNode.next = head

        head = newNode
    }

    /**
     * This function is in LinkedList class. Inserts a new node after the given prev_node.
     */
    fun insertAfter(prevNode: Node, newData: Int) {
        val newNode = Node(newData)

        newNode.next = prevNode.next

        prevNode.next = newNode
    }

    /**
     * Appends a new node at the end.
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
        var prev: Node? = null

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next
            return
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp
            temp = temp.next
        }

        if (temp != null) {
            prev?.next = temp.next
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
            return
        }

        // Find previous node of the node to be deleted
        var i = 0
        while (temp != null && i < position - 1) {
            temp = temp.next
            i++
        }

        // If position is more than number of nodes
        if (temp == null || temp.next == null) {
            return
        }

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        val deleteNode = temp.next
        temp.next = deleteNode?.next
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
    val linkedList = SinglyLinkedList()

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