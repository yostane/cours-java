///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;
import java.util.*;
import java.util.stream.*;

public class StreamDemo {

  public static void main(String... args) {
    out.println("Hello World");
    Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 100);
    var filteredNumbers = numbers.filter((n) -> n % 2 == 0);
    var doubleNumbers = filteredNumbers.map((n) -> n * 2);
    var product = doubleNumbers.reduce(Integer::sum);
    System.out.println(product);

    var otherNumbers = Stream.of(1, 2, 3, 4, 100);
    var result = otherNumbers
        .filter((n) -> n % 2 == 0)
        .map((n) -> n * 2)
        .reduce(Integer::sum);

    System.out.println(result);

    var pairNumbers = Stream.of(1, 2, 3, 4, 100)
        .filter((n) -> n % 2 == 0).toList();

    var doublePairs = pairNumbers.stream().map((n) -> n * 2).toList();
  }
}
