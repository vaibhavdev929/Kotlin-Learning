package days.day3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {




    runBlocking {
        // parent coroutine
        println("Starting")
        // launch, async, withContext

        // launch - fire and forget
       // uploadData()

        // async - collect result from coroutine
        val pathDef = async(Dispatchers.Default) {

            download()
        }

        val path = pathDef.await()
        println("Downloaded at $path")

        withContext(Dispatchers.Unconfined){

            delay(2000)
            println("showing image: $path ${Thread.currentThread().name}")
        }

        println("DONE")
    }
}

private suspend fun CoroutineScope.uploadData() {
    val uploadJob = launch(Dispatchers.Default) {
        upload()
    }

    uploadJob.cancel()

    if (uploadJob.isActive)
        uploadJob.join()
    else {
        println("upload is not happening")
    }
}

suspend fun download(): String {
    // network call
    println("download started")
    delay(3000)
    println("download finished")
    return "/android/data/xyz.jpg"
}

suspend fun upload(){
    // network call
    println("Upload started")
    delay(3000)
    println("upload finished")
}