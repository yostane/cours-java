# Modern concurrency on the JVM with Kotlin coroutines and Loom

## Introduction

It's long finished the time where the Java ecosystem only has threads.
Nowadays, we have a lot of options to write concurrent code in the JVM.
In this article, we will explore how to write concurrent code using Kotlin coroutines and Project Loom.

## Loom

Project Loom is an OpenJDK project that aims to bring modern concurrent programming to the JVM.
Loom introduces new concepts: virtual threads, Fibers and continuations.
Virtual threads are lightweight threads that are managed by the JVM.
Fibers are a way to write concurrent code that is more efficient than using threads.
Continuations are a way to pause and resume the execution of a Fiber.

### Virtual threads

Virtual threads are lightweight threads that are managed by the JVM.
They use less memory than platform threads (the ones provided by the OS) and are more efficient for tasks that spend much of their time waiting.
This means that virtual threads are more efficient for I/O-bound tasks such as network or file I/O.
Is it also possible to have many more virtual threads than platform threads which is capped due to OS and hardware limitations.
On the other hand, platform threads are more efficient for CPU-bound tasks.

### Fibers

Fibers are a way to write concurrent code that is more efficient than using threads.

### Continuations

Continuations are a way to pause and resume the execution of a Fiber.

## Kotlin coroutines

Kotlin coroutines is high level cross-platform API for writing efficient concurrent code.
It enables to write asynchronous code in a sequential way as well as structured concurrency.
The former means that you can write asynchronous code that looks like synchronous code, eliminating the callback hall problem.
The latter means that you can write concurrent code that is easy to reason about and where the start and end of concurrent paths are clear and explicit ([ref](https://www.thedevtavern.com/blog/posts/structured-concurrency-explained/)).

## Writing concurrent code with Kotlin coroutines

## Coroutines vs loom

For Java developers, project Loom is the way to go.

For Kotlin developers, both technologies are complementary and can be used together to write efficient concurrent code on the JVM.
Corourines were available since Kotlin 1.1, while Project Loom is still in development, even though some APIs are stable.

## Conclusion

Developers for the JVM have now more options to write concurrent code.
Project Loom brings new concepts to the JVM that make it easier to write efficient concurrent code.
Kotlin coroutines is a high level API that enables to write asynchronous code in a sequential way as well as structured concurrency.

## Links and references

- [Structured concurrency explained - Part 1: Introduction](https://www.thedevtavern.com/blog/posts/structured-concurrency-explained/)
