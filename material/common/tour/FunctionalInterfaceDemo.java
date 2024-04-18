///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

@FunctionalInterface
interface MyCustomBiPredicate {
  boolean doSomething(int a, int b);
}

public class FunctionalInterfaceDemo {
  static boolean returnFalse(int a, int b) {
    return false;
  }

  static void callPredicate(MyCustomBiPredicate p) {
    System.out.println(p.doSomething(10, 0));
    System.out.println(p.doSomething(0, 0));
  }

  public static void main(String... args) {
    MyCustomBiPredicate p = (a, b) -> a > b;
    System.out.println(p.doSomething(10, 20));
    p = FunctionalInterfaceDemo::returnFalse;
    System.out.println(p.doSomething(111, 0));

    callPredicate(p);
    callPredicate(FunctionalInterfaceDemo::returnFalse);
    callPredicate((a, b) -> a > b);
  }
}
