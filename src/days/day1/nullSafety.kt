package com.sapient.kotlinlearning.day1



fun main() {

    var x = 10 // non-nullable reference
    var name : String? = "xyz" // nullable reference


    name = null // null - no value


    // 1. explicit null check - smart cast
    if (name != null){

        println("Lenght: ${name.length}")
    }

    //2. safe-call operator ?.
    val len = name?.length

    name = "abc"

    println("Name: ${name?.length}")
    println("${name?.uppercase()?.length}")

    //3. elvis operator ?: - null-coalescing operator
    // converting nullable to non-nullable
    name = "john"
    var username : String

    username = name ?: "demo"

    println("Username: $username")

    //4. not-null assertion operator !! - forcefully accessing value
    name = "xyz"
    username = name!!
    println("Username : $username")

    var data = arrayOf(10, null, 20, null, 30)

    for (x in data){
        val sqr = (x ?: 0) * (x ?: 0)
        println("Square of $x : $sqr")
    }


}