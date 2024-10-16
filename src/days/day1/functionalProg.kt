package com.sapient.kotlinlearning.day1

fun multiply(a:Int, b:Int) = a * b

fun divide(a:Int, b:Int) = a / b

// functional programming - Kotlin, Swift, Dart, Go, Python, Javascript
fun main() {

    var mathOp : (Int, Int) -> Int

    mathOp = ::multiply // function referencing operator - ::
    var result = mathOp(10, 20)
    println("Product: $result")

    mathOp = ::divide
    result = mathOp.invoke(10,2)
    println("Division: $result")

    doOperation(1, 10, ::multiply)
    doOperation(100, 10, ::divide)

    var number = -5

    while (number != 0){
        number = makeZero(number)()
        println("number: $number")
    }

    // lamda expression - annonymous functions

//    val someFun = { arg1: Int, arg2: Int ->
//        println("Doing sum")
//        arg1 + arg2
//    }

    doOperation(10, 20, { arg1: Int, arg2: Int ->
        println("Doing sum")
        arg1 + arg2
    })

    // trailing lambda

    doOperation(20, 5) { a, b ->
        println("doing multiplication")
        a * b
    }

    val data = listOf(1,2,3,4,5,6,7,8)

    // it - single arg in lambda
    val evenNumbers = data.filter {
        it % 2 == 0
    }

    println(evenNumbers)

    val cumSum = data.reduce { sum, arg ->
        sum + arg
    }

    println("cumsum : $cumSum")

    data.forEach {
        println("Square of $it : ${it * it}")
    }

    dojob()

    val x = 10
    println(x.increment(2))

    println(x increment 10)

    10 downTo 1 step 2
}

// inline functions

inline fun dojob(){
    println("doing coding")
}


// higher order functions

inline fun doOperation(arg1: Int, arg2: Int, noinline operation: (Int, Int) -> Int){
    val result = operation(arg1, arg2)
    println("Result: $result")
}

// higher order func
fun makeZero(num: Int) : () ->Int {
    val pi = 3.142
    fun increment() = num + 1
    fun decrement() = num - 1

    return if (num < 0) ::increment else ::decrement
}

// extension function

infix fun Int.increment(by: Int) : Int {
    return this + by
}


// infix functions - single arg, member of class
