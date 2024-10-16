package days.day3

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    val channel = Channel<String>()

    runBlocking {

        launch {
            println("task 1 ${Thread.currentThread().name}")
            delay(2000)
            channel.send("hello")
            println("task1 sent")
            channel.send("hi")
        }
        launch {
            println("task 2 ${Thread.currentThread().name}")
            delay(2000)
            val data = channel.receive()
            println("Received by task2 $data")
        }
        launch {
            println("task 3 ${Thread.currentThread().name}")
            val data = channel.receive()
            println("Received $data")

        }
    }
}