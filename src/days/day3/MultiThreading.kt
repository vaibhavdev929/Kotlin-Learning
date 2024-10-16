package com.sapient.kotlinlearning.day3

import kotlin.concurrent.thread

fun main() {

    println("main executed by ${Thread.currentThread().name}")
    val t1 = thread {
        println("t1 task started..by ${Thread.currentThread().name}")
        Thread.sleep(2000)
        println("t1 task finished")
    }
    println("task is going on")


    t1.join()
    println("t1 done")

    doTask()
}

fun doTask(){
    for (i in 0..1_00_000) {
        thread {
            print(".")
            Thread.sleep(1000)
        }
    }
}