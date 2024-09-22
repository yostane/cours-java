/// usr/bin/env jbang "$0" "$@" ; exit $?


//DEPS org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.8.1

import kotlinx.coroutines.*

public fun main() {
  runBlocking {
    launch {
      delay(1000L)
      println("World!")
    }
    println("Hello")
  }
}
