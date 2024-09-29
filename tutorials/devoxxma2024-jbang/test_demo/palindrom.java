///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17+
// Update the Quarkus version to what you want here or run jbang with
// `-Dquarkus.version=<version>` to override it.
//DEPS io.quarkus:quarkus-bom:${quarkus.version:3.7.2}@pom
//DEPS io.quarkus:quarkus-picocli
//Q:CONFIG quarkus.banner.enabled=false
//Q:CONFIG quarkus.log.level=WARN

import picocli.CommandLine;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.QuarkusApplication;

import static java.lang.System.out;

import io.quarkus.runtime.Quarkus;

@CommandLine.Command
public class palindrom implements Runnable {

    @CommandLine.Parameters(index = "0", description = "The input word", defaultValue = "World!")
    String input;

    @Inject
    CommandLine.IFactory factory;

    private final PalindromeService plaindromService;

    public palindrom(PalindromeService greetingService) {
        this.plaindromService = greetingService;
    }

    @Override
    public void run() {
        out.println(plaindromService.isPalindrom(input));
    }

}

@Dependent
class PalindromeService {
    boolean isPalindrom(String input) {
        int l = input.length();
        for (int i = 0; i < l / 2; i++) {
            if (input.charAt(i) != input.charAt(l - i - 1)) {
                return false;
            }
        }
        return true;
    }
}