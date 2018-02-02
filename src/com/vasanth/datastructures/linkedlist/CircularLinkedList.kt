package com.vasanth.datastructures.linkedlist

// CircularLinkedList Data Structure

/**
 * CircularLinkedList.
 */
class CircularLinkedList {

    var last: Node? = null

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

        // If list is empty then link single node to itself & it is the last node.
        if (last == null) {
            newNode.next = newNode
            last = newNode
            return
        }

        // Else - insert it at the front of the list.
        newNode.next = last?.next
        last?.next = newNode
    }

    /**
     * This function is in LinkedList class. Inserts a new node after the given prev_node.
     */
    fun insertAfter(prevNode: Node, newData: Int) {
        val newNode = Node(newData)

        newNode.next = prevNode.next

        prevNode.next = newNode

        // If prevNode is the last node, then change it to newly inserted node.
        if (last == prevNode) {
            last = newNode
        }
    }

    /**
     * Appends a new node at the end.
     */
    fun append(newData: Int) {
        val newNode = Node(newData)

        // If list is empty then link single node to itself & it is the last node.
        if (last == null) {
            newNode.next = newNode
            last = newNode
            return
        }

        // Else - insert it at the end of the list & update last.
        newNode.next = last?.next
        last?.next = newNode
        last = newNode
    }

    /**
     * DELETING A NODE
     */

    /**
     * Given a key, deletes the first occurrence of key in linked list.
     */
    fun deleteNode(key: Int) {
        if (last == null) {
            return
        }

        val first = last?.next
        var temp = first
        var prev: Node? = null

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != last && temp?.data != key) {
            prev = temp
            temp = temp?.next
        }

        // If we have iterated to last node and not found the data then return.
        if (temp == last && temp?.data != key) {
            return
        }

        // Else If it is the only node in the list, then set last to null.
        if (temp == first && temp == last) {
            last = null
        }

        // Else If it is the First node - Then set "last.next = temp.next"
        else if (temp == first) {
            last?.next = temp?.next
        }

        // Else If it is the Last node - Then make previous node as last node.
        else if (temp == last) {
            prev?.next = temp?.next
            last = prev;
            return
        }

        // Else if it is any middle node - Then make previous node to point to next of deleted node.
        else {
            prev?.next = temp?.next
        }
    }

    /**
     * TRAVERSING THE LIST
     */

    // This function prints contents of linked list starting from head
    fun printList() {
        // Go to first element.
        var temp = last?.next

        if (temp != null) {
            do {
                print("${temp!!.data}  ")
                temp = temp.next
            } while (temp != last)
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

        var temp = last?.next
        while (temp != last) {
            count++
            temp = temp?.next
        }

        return count
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val linkedList = CircularLinkedList()

    linkedList.append(6)

    linkedList.push(7)

    linkedList.push(1)

    linkedList.append(4)

    linkedList.insertAfter(linkedList.last!!.next!!.next!!, 8)

    println("\nCreated Linked list is: ")
    linkedList.printList();

    linkedList.deleteNode(8)

    println("\nLinked List after Deletion of key 8:")
    linkedList.printList()

    println("\nCount of nodes is " + linkedList.getCount());
}