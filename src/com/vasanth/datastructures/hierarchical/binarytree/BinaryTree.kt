package com.vasanth.datastructures.hierarchical.binarytree

import java.util.*

// Binary Tree Data Structure.

/**
 * Class containing left and right child of current node and key value.
 */
class Node {

    var key: Int
    var left: Node? = null
    var right: Node? = null

    constructor(key: Int) {
        this.key = key
    }
}

class BinaryTree {

    var root: Node? = null

    /**
     * DEPTH FIRST TRAVERSAL.
     */

    /**
     * Given a binary tree, print its nodes in preorder.
     */
    private fun printPreOrder(node: Node?) {
        if (node == null) {
            return
        }

        // first print data of node
        print("${node.key} ")

        // then recur on left subtree
        printPreOrder(node.left)

        // now recur on right subtree
        printPreOrder(node.right)
    }

    /**
     * Given a binary tree, print its nodes in inorder.
     */
    private fun printInOrder(node: Node?) {
        if (node == null) {
            return
        }

        // first recur on left child
        printInOrder(node.left)

        // then print the data of node
        print("${node.key} ")

        // now recur on right child
        printInOrder(node.right)
    }

    /**
     * Given a binary tree, print its nodes according to the "bottom-up" postorder traversal.
     */
    private fun printPostOrder(node: Node?) {
        if (node == null) {
            return
        }

        // first recur on left subtree
        printPostOrder(node.left)

        // then recur on right subtree
        printPostOrder(node.right)

        // now deal with the node
        print("${node.key} ")
    }

    // Wrappers over above recursive functions
    fun printPreOrder() {
        printPreOrder(root)
    }

    fun printInOrder() {
        printInOrder(root)
    }

    fun printPostOrder() {
        printPostOrder(root)
    }

    /**
     * BREADTH FIRST TRAVERSAL
     */

    /**
     * Given a binary tree. Print its nodes in level order using array for implementing queue
     */
    fun printLevelOrder() {
        val queue: Queue<Node> = LinkedList<Node>()
        queue.add(root)

        while (!queue.isEmpty()) {
            // poll() removes the present head.
            val tempNode = queue.poll()
            print("${tempNode.key} ")

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left)
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right)
            }
        }
    }
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val tree = BinaryTree()
    tree.root = Node(1)
    tree.root?.left = Node(2)
    tree.root?.right = Node(3)
    tree.root?.left?.left = Node(4)
    tree.root?.left?.right = Node(5)

    println("Preorder traversal of binary tree is ")
    tree.printPreOrder()

    println("\nInorder traversal of binary tree is ")
    tree.printInOrder()

    println("\nPostorder traversal of binary tree is ")
    tree.printPostOrder()

    println("\nLevelorder traversal of binary tree is ")
    tree.printLevelOrder()
}