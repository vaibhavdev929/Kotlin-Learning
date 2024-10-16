package com.sapient.kotlinlearning.day2

// primary constructor - one
// secondary constructors - many

// access modifier - public(default), private, protected, internal

class Student( name: String,
              val rollNo: Int) {
    // data/properties

    var marks: Int = 0
    var name: String

    // computed properties
    var percentage : Int
        get() {
            return marks/500 * 100
        }
        set(value) {
           marks = value * 500 / 100
        }

    //secondary
    constructor(name: String, rNo: Int, marks: Int) : this(name, rNo) {
        println("Secondary")
        this.marks = marks
    }

    init {
        println("init executed for $name")
        this.name = name.uppercase()
    }

    // methods
    fun display(){
        println("Name: $name")
        println("RollNo: $rollNo")
        println("Marks: $marks")
    }

    // Any - superclass
    override fun toString(): String {
        return "$name, $rollNo"
    }



}

fun main() {
    val std1 = Student("john", 1)
    std1.marks = 90

    std1.display()

    val std2 = Student("merry", 2)
    std2.display()

    val std3 = Student("robert", 3, 78)
    std3.display()

    println(std3)

    println(std3.percentage)
    std3.percentage = 90 // set execution

}