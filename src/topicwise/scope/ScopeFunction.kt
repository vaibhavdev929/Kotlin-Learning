package topicwise.scope

data class ScopeFunctionTest(var name: String, var age: Int) {
    fun printDetails() {
        println("Name is: $name and age is: $age")
    }
}


fun main() {

    val obj = ScopeFunctionTest("Vaibhav", 28)
    applyFunctionExample(obj)
    alsoFunctionExample(obj)
}

fun applyFunctionExample(obj: ScopeFunctionTest) {
    obj.apply {
        name = "Vaibhav's New name"
        age = 29
        log(this)
        printDetails()
    }
}

fun alsoFunctionExample(obj: ScopeFunctionTest) {
    obj.also {
        it.name = "Vaibhav's New name"
        it.age = 29

    }
    println("Name is: ${obj.name} and age is: ${obj.age}")
}

fun log(obj :ScopeFunctionTest )
{

}



