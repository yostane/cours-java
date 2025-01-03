/// usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+
//COMPILE_OPTIONS --enable-preview -source 25
//RUNTIME_OPTIONS --enable-preview

import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;

import static java.lang.System.*;

void main(String... args) {
  out.println("Hello Java 25");
  Callable<String> task1 = () -> {
    out.println("Task 1" + Thread.currentThread());
    return "Task 1";
  };

  Callable<Integer> task2 = () -> {
    out.println("Task 2" + Thread.currentThread());
    return 2;
  };

  try (
    var scope = new StructuredTaskScope<Object>()) {
    StructuredTaskScope.Subtask<String> subtask1 = scope.fork(task1);
    StructuredTaskScope.Subtask<Integer> subtask2 = scope.fork(task2);
    scope.join();
  } catch (Exception e) {
    e.printStackTrace();
  }
}