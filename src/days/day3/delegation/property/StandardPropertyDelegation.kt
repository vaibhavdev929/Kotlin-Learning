package days.day3.delegation.property

import kotlin.properties.Delegates

/**
 * Lazy properties: the value is computed only on first access.
 *
 * By default, the evaluation of lazy properties is synchronized: the value is computed only in one thread,
 * but all threads will see the same value.
 * If the synchronization of the initialization delegate is not required to allow multiple threads to execute it simultaneously,
 * pass LazyThreadSafetyMode.PUBLICATION as a parameter to lazy().
 *
 * If you're sure that the initialization will always happen in the same thread as the one where you use the property,
 * you can use LazyThreadSafetyMode.NONE. It doesn't incur any thread-safety guarantees and related overhead.
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

//fun main() {
//    println(lazyValue)
//    println(lazyValue)
//}

/**
 * Observable properties: listeners are notified about changes to this property.
 *
 * Delegates.observable() takes two arguments: the initial value and a handler for modifications.
 *
 * The handler is called every time you assign to the property (after the assignment has been performed).
 * It has three parameters: the property being assigned to, the old value, and the new value:
 */

class User {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("$old -> $new")
    }
}

/**
 * If you want to intercept assignments and veto them, use vetoable() instead of observable().
 * The handler passed to vetoable will be called before the assignment of a new property value.
 */
class User2 {
    var name: Int by Delegates.vetoable(0) { prop, old, new ->
        new > old
    }
}

fun main() {
    val user = User()
    user.name = "first"
    user.name = "second"
}