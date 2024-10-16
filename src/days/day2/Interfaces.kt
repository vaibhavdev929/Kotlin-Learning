package com.sapient.kotlinlearning.day2

// by default open, cannot instantiate
abstract class A{
    fun method1(){
        println("MEthod 1")
    }
}

interface MathInterface {

    // required
    fun add(a: Int, b: Int): Int

    // optional
    fun multiply(a:Int, b:Int): Int {
        return a * b
    }
}

class B: A(), MathInterface{
    override fun add(a: Int, b: Int): Int {
        return a + b
    }

    override fun multiply(a: Int, b: Int): Int {
        return super.multiply(a, b) * 10
    }

}



fun main() {
    val obj = B()
    var result = obj.add(10,20)
    println("SUM: $result")
    result = obj.multiply(10, 20)
    println("Product: $result")


}