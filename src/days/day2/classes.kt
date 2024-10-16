package days.day2



// cannot be open/ abstract
// atleast one property marked with var/val
// toString()
data class Point(var x: Int, var y: Int) {


    operator fun plus(p: Point): Point {
        return Point(this.x + p.x, this.y + p.y)
    }
    // operator overloading

}

// toSting()
data object Config{
    val url: String = "http://google.com"
}

// singleton design pattern -
// private constructor, static instance

// declaring and creating
object DBUtility{
    val db_name = "auth.db"

    fun connect(){
        println("Connecting to $db_name")
    }
}

// object expression - annoymous implementation of interface

fun main() {
//
//    DBUtility.connect()
//    // object expression
//    val handler = object : OnClickListener {
//        override fun onClick(v: View?) {
//
//        }
//
//    }
//
//    val p1 = Point(10, 20)
//    println(p1)
//
//    val p2 = Point(10, 20)
//
//    val p3 = p1 + p2
//    println(p3)
}