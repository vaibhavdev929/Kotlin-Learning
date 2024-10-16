package com.sapient.kotlinlearning.day3

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class UpperStrDelegate{
    private var str = ""

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return str.uppercase()
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String){
        str = value
    }
}

class Person {
    var firstName : String by UpperStrDelegate()
    var lastName: String by UpperStrDelegate()
}

class User(val map : Map<String, Any>) {
    val userid: String by map
    val password: String by map
    val age: Int by map

    fun validate(){
        println("validating $userid $password")
    }
}

class Utility {

    val configContent : String by lazy {
        // read file
        println("Reading file")
        "some file content"
    }

    var db_name: String by Delegates.observable("auth.db"){
        _, oldValue, newValue ->
        // do action for db change
        println("db changed from $oldValue to $newValue")

    }

    init {
        println("utility init")
    }

}

fun main() {
    val p1 = Person()
    p1.firstName = "john"
    p1.lastName = "smith"

    println(p1.firstName)
    println(p1.lastName)

    val util = Utility()

    println(util.configContent)
    println(util.configContent)

    util.db_name = "new.db"

    val user = User(mapOf("userid" to "john", "password" to "123", "age" to 20))
    user.validate()

}