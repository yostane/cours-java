///usr/bin/env jbang "$0" "$@" ; exit $?
//COMPILE_OPTIONS --enable-preview -source 21
//RUNTIME_OPTIONS --enable-preview

import static java.lang.System.*;

import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class StructuredTaskScopeDemo {

  public static void main(String... args) {
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
      Subtask<String> subtask1 = scope.fork(task1);
      Subtask<Integer> subtask2 = scope.fork(task2);
      scope.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
