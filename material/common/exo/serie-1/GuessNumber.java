///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

import java.util.Scanner;
import java.util.random.RandomGenerator;

public class GuessNumber {

  public static void main(String... args) {
    var r = RandomGenerator.getDefault();
    int numberToGuess = r.nextInt(1, 21);

    Scanner scanner = new Scanner(System.in);

    int proposition = scanner.nextInt();
    while (proposition != numberToGuess) {
      if (proposition < numberToGuess) {
        System.out.println("Plus");
      } else {
        System.out.println("Moins");
      }
      proposition = scanner.nextInt();
    }
    System.out.println("Gagné");
    scanner.close();
  }
}
