package com.sapient.kotlinlearning.day1

import kotlin.time.Duration

fun add(a: Int, b: Int): Int {
    return  a + b
}

// Unit - no return
fun display(name: String, age: Int, city: String){
    println("Name: ${name.uppercase()}")
    println("Age: ${age}")
    println("City: ${city.uppercase()}")
    return
}

// function with default values
// rule - default args to be followed after mandatory
fun calculateEMI( amount: Int, rate: Int = 10, duration: Int = 12 ){

}

// variable length args
// rule - to be followed after mandatory and only one
fun cumulativeProduct(initialValue: Int, vararg numbers: Int){
    var result = initialValue
    for (num in numbers){
        result *= num
    }
    println("Product: $result")
}


fun main() {

    cumulativeProduct(10)
    cumulativeProduct(1,2,3,4,5)

    display("john", 10, "Pune")
    display(age = 30, name = "mark", city = "New york") // named args

    calculateEMI(1000)
    calculateEMI(1000, 20)
    calculateEMI(1000, duration = 24)


}

