package cs.med.mtz.moises.lyrics

import android.content.res.Resources
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    //blokingExample()
    //suspendExample()
    //suspendExample2()
    //dispacher()
    //launch()
    //esxampleJov()
    //Thread.sleep(5000)
    //asincAwait()
    //asincAwaitDeferred()
    //println(measureTimeMillis { withContextIO() }).toString()
    cancelCoroutine()
}

//bloquear
fun lognTaskWithMessage(message: String) {
    Thread.sleep(4000)
    println(message + Thread.currentThread().name)
}

fun blokingExample() {
    println("tarea 1" + Thread.currentThread().name)
    //lognTaskWithMessage("tarea 2")
    //delayCoroutine("tarea2")
    println("tarea 3" + Thread.currentThread().name)
}

//suspend
suspend fun delayCoroutine(message: String) {
    delay(timeMillis = 4000)
    println(message + Thread.currentThread().name)
}

//Run Blocking
fun suspendExample() {
    println("tarea 1" + Thread.currentThread().name)
    runBlocking {
        delayCoroutine("tarea 2")
    }
    println("tarea 3" + Thread.currentThread().name)
}

fun suspendExample2() = runBlocking {
    println("tarea 1" + Thread.currentThread().name)
    delayCoroutine("tarea 2")
    println("tarea 3" + Thread.currentThread().name)
}

fun dispacher() {
    runBlocking {
        println("Hilo en el que se ejecuta 1: ${Thread.currentThread().name}")
    }
    runBlocking(Dispatchers.Unconfined) {
        println("Hilo en el que se ejecuta 2 : ${Thread.currentThread().name}")
    }
    runBlocking(Dispatchers.Default) {
        println("Hilo en el que se ejecuta 3: ${Thread.currentThread().name}")
    }
    runBlocking(Dispatchers.IO) {
        println("Hilo en el que se ejecuta 4: ${Thread.currentThread().name}")
    }
}

fun launch() {
    println("tarea 1" + Thread.currentThread().name)
    GlobalScope.launch {
        delayCoroutine("tarea 2")
    }
    println("tarea 3" + Thread.currentThread().name)
}

/**
 *
 */

fun esxampleJov() {
    println("tarea 1" + Thread.currentThread().name)
    val jov = GlobalScope.launch {
        delayCoroutine("tarea 2")
    }
    println("tarea 3" + Thread.currentThread().name)
    jov.cancel()
}

/**
 *
 */
suspend fun calculaterHard(): Int {
    delay(2000)
    return 15
}

fun asincAwait() = runBlocking {
    println(System.currentTimeMillis().toString())
    val number1 = async { calculaterHard() }.await()
    println(System.currentTimeMillis().toString())
    val number2 = async { calculaterHard() }.await()
    println(System.currentTimeMillis().toString())
    val result = number1 + number2
    println(result.toString())

}

fun asincAwaitDeferred() = runBlocking {
    println(System.currentTimeMillis().toString())
    val number1: Deferred<Int> = async { calculaterHard() }
    println(System.currentTimeMillis().toString())
    val number2 = async { calculaterHard() }
    println(System.currentTimeMillis().toString())
    val result = number1.await() + number2.await()
    println(result.toString())

}

fun withContextIO() = runBlocking {
    val number1 = withContext(Dispatchers.IO) { calculaterHard() }
    val number2 = withContext(Dispatchers.IO) { calculaterHard() }
    val result = number1 + number2
    println(result.toString())
}

fun cancelCoroutine() {
    runBlocking {
        val jov = launch {
            repeat(1000) { i ->
                println("jov: $i")
                delay(500L)
            }
        }
        delay(1400)
        jov.cancel()
        println("cansado de esperar")
    }


}