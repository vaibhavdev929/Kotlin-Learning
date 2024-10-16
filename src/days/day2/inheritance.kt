package com.sapient.kotlinlearning.day2


/*
types of inheritances

    - Single
        A->B
    - multilevel
        A->B->C
    - multiple (Not supported)
        A,B->C
    - hierarchical
        A->B, A->C
 */

open class Employee(val name: String, val empId: Int, var salary: Int) {

    open var bonus = 100
    // instance property
    init {
        empCount++
        print("init of Empl")
    }



    open fun display(){
        println("Name: $name")
        println("ID: $empId")
        println("Salary: $salary")
    }

    // class level / static
    companion object{
        var empCount = 0

        fun displayCount(){
            println("Emp Count: $empCount")
        }
    }
}

class Developer(name:String, id: Int, salary: Int,
                var skill: String): Employee(name, id, salary) {

                    override var bonus = 200
    init {
        println("init of developer")
    }
    override fun display(){
        super.display()
        println("Skill: $skill")
    }
}

fun main() {

    val emp1 = Employee("john", 1, 1000)
    val emp2 = Developer("merry", 2, 2000, "Kotlin")

    emp1.display()
    emp2.display()

    //println("Total count: ${Employee.empCount}")
    Employee.displayCount()


}
