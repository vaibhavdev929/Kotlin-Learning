package topicwise.classes

/**
1. Data class have at least  one primary constructor.
2. Data class extends other type of class , Like interface , abstract And class.
3. It generates equals(), hashCode(), toString(), and copy() methods automatically.
 */

open class Person(val name: String, val age: Int)
abstract class AbstractPerson(val name: String, val age: Int)
interface InterfacePerson {
}

data class DataClassExample(val name1: String, val age1: Int) : InterfacePerson {
}

