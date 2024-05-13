///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;
import java.util.*;

public class NullSafety {

  static String getFromInternet() {
    return "dsfsdfdsf";
  }

  static Optional<String> getFromInternetOpt() {
    return Optional.of("dsfsdfdsf");
  }

  public static void main(String... args) {
    out.println("Hello World");

    Optional<String> myOptionalText = Optional.empty();
    if (myOptionalText.isPresent()) {
      System.out.println(myOptionalText.get());
    }
    var optioanlValue = getFromInternetOpt();
    if (optioanlValue.isPresent()) {
      System.out.println(optioanlValue.get());
    }
  }
}
