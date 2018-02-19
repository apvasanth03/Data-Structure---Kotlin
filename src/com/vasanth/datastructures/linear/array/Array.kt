package com.vasanth.datastructures.linear.array

// Array Data Structure

// Declaring Array
val arr: Array<Int> = arrayOf(10, 20, 30, 40, 50)


// Accessing elements in Array
fun printElements(){
    println("Array Elements : ")
    for (item in arr){
        println(item)
    }
}

fun main(args : Array<String>) {
    printElements()
}