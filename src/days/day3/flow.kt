package days.day3

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    // publisher- flow builders

    // cold flow - data stream is produced when there is a collector
    val numFlow = flow<Int> {

        for (i in 1..10){
            delay(1000)
            emit(i)
        }
    }


    // formatting(optional)

//    val sqrFlow = numFlow.map {
//        it * it
//    }
//
//    // collector
//
//    runBlocking {
//        launch {
//            sqrFlow.collect {
//                println("REceived $it")
//            }
//        }
//        launch {
//            sqrFlow.collect {
//                println("REceived again $it")
//            }
//        }
//    }

}