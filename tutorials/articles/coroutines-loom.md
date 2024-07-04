# Modern concurrency on the JVM with Kotlin Coroutines and Loom

It's long finished the time where the Java ecosystem only has threads and async callback hells.
Nowadays, we have a lot of options to write elegant concurrent code in the JVM.
That what we'll explore in this article through Project Loom and Kotlin coroutines.

## Introduction

In modern concurrent programming, we have two main concepts: soft threads and structured concurrency.
Soft threads are lightweight threads that are managed by the runtime, while structured concurrency is a way to write to write concurrent code that is organized and clear.
Structured concurrency thus avoids us writing async callbacks and uses classic programming constructs (loops, if, etc.).

In the JVM ecosystem, we have two main technologies that enable us to write efficient concurrent code: Project Loom and Kotlin coroutines.
The first one can be used by both Java and Kotlin developers, while the second one is specific to Kotlin developers.

Let's start by exploring Project Loom.

## Loom

Project Loom is an OpenJDK project that aims to bring modern concurrent programming to the JVM.
Loom introduces new concepts: virtual threads ([JEP 444](https://openjdk.org/jeps/444) previously called Fibers) and structured concurrency ([JEP 428](https://openjdk.org/jeps/425)).

### Virtual threads

Virtual threads are lightweight threads that are managed by the JVM.
They use less memory than platform threads (the ones provided by the OS) and are more efficient for tasks that spend much of their time waiting.
This means that virtual threads are more efficient for I/O-bound tasks such as network or file I/O.
Is it also possible to have many more virtual threads than platform threads which is capped due to OS and hardware limitations.
On the other hand, platform threads are more efficient for CPU-bound tasks.

### Java's structured concurrency

The main class for achieve structured concurrency in Java is the [StructuredTaskScope](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/StructuredTaskScope.html).
It is available in Java 21 as a preview feature.

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
- [Project Loom: Understand the new Java concurrency model](https://www.infoworld.com/article/3652596/project-loom-understand-the-new-java-concurrency-model.html)
