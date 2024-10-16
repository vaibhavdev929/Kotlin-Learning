package com.sapient.kotlinlearning.day1




fun main() {
    println("Hello World!")

    val city = "Bangalore" // immutable
    //city = "pune"

    var name: String // mutable

    name = "Shridevi"
    name = "Sapient"

    val pi: Float

    pi = 3.142f

    println("Name: $name") // String interpolation
    println("PI doubled: ${pi * 2}")
    println("PI: ${pi.toDouble()}")

    val number = 24 // Int
    var isEven = number % 2 == 0

    println("$number is even? : $isEven")

    val alpha = 'a'

    println("Character: $alpha, ASCII: ${alpha.code}")

    val message = """
        Hello
        Good morning
    """.trimIndent()


    println(message)

    if (message.isNotEmpty())
        println("First char: ${message.first()}")

    val uppered = message.uppercase()
    println(message)
    println("Uppered: $uppered")

    if (name == message){
        println("$name and $message are having same value")
    }
    else {
        println("$name and $message are having different value")
    }

    val anotherName = name
    if (name === anotherName){
        println("both are referencing same object")
    } else {
        println("both are referencing diff object")
    }
}