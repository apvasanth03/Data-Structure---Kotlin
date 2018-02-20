package com.vasanth.datastructures.hierarchical.binarytree

import java.util.*

// Binary Tree Data Structure.

class BinaryTree {

    var root: Node? = null

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

    /**
     * DEPTH FIRST TRAVERSAL.
     */

    /**
     * Given a binary tree, print its nodes in preorder.
     */
    private fun printPreOrder(root: Node?) {
        if (root == null) {
            return
        }

        // first print data of root
        print("${root.key} ")

        // then recur on left subtree
        printPreOrder(root.left)

        // now recur on right subtree
        printPreOrder(root.right)
    }

    /**
     * Given a binary tree, print its nodes in inorder.
     */
    private fun printInOrder(root: Node?) {
        if (root == null) {
            return
        }

        // first recur on left child
        printInOrder(root.left)

        // then print the data of root
        print("${root.key} ")

        // now recur on right child
        printInOrder(root.right)
    }

    /**
     * Given a binary tree, print its nodes according to the "bottom-up" postorder traversal.
     */
    private fun printPostOrder(root: Node?) {
        if (root == null) {
            return
        }

        // first recur on left subtree
        printPostOrder(root.left)

        // then recur on right subtree
        printPostOrder(root.right)

        // now deal with the root
        print("${root.key} ")
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
    tree.root = BinaryTree.Node(1)
    tree.root?.left = BinaryTree.Node(2)
    tree.root?.right = BinaryTree.Node(3)
    tree.root?.left?.left = BinaryTree.Node(4)
    tree.root?.left?.right = BinaryTree.Node(5)

    println("Preorder traversal of binary tree is ")
    tree.printPreOrder()

    println("\nInorder traversal of binary tree is ")
    tree.printInOrder()

    println("\nPostorder traversal of binary tree is ")
    tree.printPostOrder()

    println("\nLevelorder traversal of binary tree is ")
    tree.printLevelOrder()
}