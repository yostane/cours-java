/// usr/bin/env jbang "$0" "$@" ; exit $?

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
