package com.vasanth.datastructures.hierarchical.binarytree

// Binary Search Tree Data Structure.

class BinarySearchTree {

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
     * INSERTION.
     */
    /**
     * Insert's the given key in BST.
     */
    fun insert(key: Int) {
        root = insertRec(root, key)
    }

    /**
     * A recursive function to insert a new key in BST
     */
    private fun insertRec(root: Node?, key: Int): Node {
        // If the tree is empty Or we reached child of leaf node then return a new node
        if (root == null) {
            val node = Node(key)
            return node
        }

        // Otherwise, recur down the tree
        if (root.key > key) {
            root.left = insertRec(root.left, key)
        } else {
            root.right = insertRec(root.right, key)
        }

        // Return the (unchanged) node pointer
        return root
    }

    /**
     * DELETION.
     */
    /**
     * Delete the given key from BST.
     */
    fun delete(key: Int) {
        root = deleteRec(root, key)
    }

    /**
     * Utility function to delete a given key from BST.
     */
    private fun deleteRec(root: Node?, key: Int): Node? {
        if (root == null) {
            return null
        }

        // Recur to find Node to delete.
        if (root.key > key) {
            root.left = deleteRec(root.left, key)
        } else if (root.key < key) {
            root.right = deleteRec(root.right, key)
        }

        // if key is same as root's key, then This is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.right == null) {
                return root.left
            } else if (root.left == null) {
                return root.right
            }
            // node with two children: Get the inorder successor (smallest in the right subtree)
            else {
                root.key = minValue(root.right!!)

                // Delete the inorder successor
                root.right = deleteRec(root.right, root.key)
            }
        }
        return root;
    }

    /**
     * Utility function to get minimum value in a given BST.
     */
    private fun minValue(root: Node): Int {
        var tempRoot = root
        var minValue = tempRoot.key
        while (tempRoot.left != null) {
            tempRoot = tempRoot.left!!
            minValue = tempRoot.key
        }
        return minValue
    }


    /**
     * SEARCH.
     */
    fun search(key: Int): Node? {
        return search(root, key)
    }

    /**
     * A utility function to search a given key in BST.
     */
    private fun search(root: Node?, key: Int): Node? {
        if (root == null) {
            return null
        }

        // key is present at root
        if (root.key == key) {
            return root
        }

        // val is greater than root's key
        if (root.key > key) {
            return search(root.left, key)
        }

        // val is less than root's key
        return search(root.right, key)


    }

    /**
     * TRAVERSAL.
     */
    /**
     * Print its nodes in inorder (InOrder Traversal prints BST in ascending order).
     */
    fun printInOrder() {
        printInOrder(root)
    }

    /**
     * A utility function to do inorder traversal of BST.
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
}

/**
 * Main.
 */
fun main(args: Array<String>) {
    val bst = BinarySearchTree()

    /*
    Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
    */

    bst.insert(50)
    bst.insert(30)
    bst.insert(20)
    bst.insert(40)
    bst.insert(70)
    bst.insert(60)
    bst.insert(80)

    // print inorder traversal of the BST
    println("Binary Search Tree : ")
    bst.printInOrder()

    // Search key
    print("\nSearch for key 40 in BST : ")
    val node1 = bst.search(40)
    if (node1 != null) {
        print("Found")
    } else {
        print("Not Found")
    }

    // Delete Key
    println("Binary Search Tree after deleting key 80 : ")
    bst.delete(80)
    bst.printInOrder()

}