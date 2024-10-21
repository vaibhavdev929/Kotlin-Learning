package days.day3.delegation.property


import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringUpperCaseDelegate {
    private var str = ""
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return str.uppercase()
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        str = value
    }

}

class PropertyDelegation : ReadOnlyProperty<Any,String>
{
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        TODO("Not yet implemented")
    }

}
class StringUpperCaseDelegate1 : ReadWriteProperty<Any,String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        TODO("Not yet implemented")
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        TODO("Not yet implemented")
    }


}

fun main() {
    var name: String by StringUpperCaseDelegate()
    name = "vaibhav"

    println(name)
}