fun main() {
    println("Hello World!")

    val list = ArrayList<Student>()
    list.add(Student("namm1", 60.00))
    list.add(Student("namm1", 30.00))
    list.add(Student("namm1", 90.00))


    val list2 = list.filter {
        it.grade > 50
    }
    list.sortByDescending {
        it.grade
    }


    println(list2)
    println(list)

}


data class Student(val name: String, val grade: Double)

