package com.sapient.kotlinlearning.day2

fun main() {
    val std = Student("john", 1)
    std.marks = 200
    println("percentage: ${std.percentage}")

    // apply/also - return object
    val std1 = Student("merrry", 2).apply {
        // initialisation
        // referene - 'this'
        marks = 200

    }.also {
        // reference - 'it'
        println("percentage: ${it.marks}")
        it.display()
    }

    // let, run - return last expression, null checks

    var name: String? = "john"

    name?.run {
        // reference - this
        println(length)
        println(uppercase())
    }

    name?.let {
        // reference 'it'
        log(it)
    }

    // with = non-nullable reference

    with(std1){
        display()
        println(percentage)
    }
}

fun log(msg: String){
    println(msg)
}

/*
Scoping functions - let, run, with, also, apply
 */