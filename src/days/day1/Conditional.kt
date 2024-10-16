package com.sapient.kotlinlearning.day1

fun main() {

    val arg1 = 10
    val arg2 = 20

    var maxNumber : Int = 0

    if (arg1 > arg2) {
        maxNumber = arg1
    }
    else {
        maxNumber = arg2
    }

    println("MAX: $maxNumber")

    // if as a expression - no ternary op
    // else is mandatory

    maxNumber = if (arg1 > arg2) {

        println("arg1 is higher than arg2")
        arg1
    } else  {
        println("arg2 is higher")
        arg2
    }

    println("MAX: $maxNumber")

    // when - as a statement or expression

    val marks = 90

    // when as statement else is not mandatory
    when(marks) {
        100 -> println("Excellent")
        in 75..100 -> println("Distinction")
        in 65..75 -> println("First class")

    }

    //  when as expression

    var grade = ""

    grade = when(marks){
        100 -> "A+"
        in 75..100 -> {
            println("Distinction")
            "A"
        }
        in 65..75 -> {
            println("First class")
            "B+"
        }

        else -> {
            "Fail"
        }
    }

    println("Grade : $grade")

    // when as alternative to if-else-if
    val arg: Any = 100

    //smart-casting
    when {
        arg is Int -> println("square : ${arg * arg}")
        arg is String -> println("Uppercased: ${arg.uppercase()}")
        arg1 == arg2 -> println("same")
    }
 }