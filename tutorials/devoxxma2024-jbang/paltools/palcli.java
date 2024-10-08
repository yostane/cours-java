///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.3
//SOURCES PalindromeService.java

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "palcli", mixinStandardHelpOptions = true, version = "palcli 0.1", description = "palcli made with jbang")
class palcli implements Callable<Integer> {

    @Parameters(index = "0", description = "The greeting to print", defaultValue = "World!")
    private String inputString;

    public static void main(String... args) {
        int exitCode = new CommandLine(new palcli()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println(PalindromeService.isPalindrome(inputString) ? "Palindrome" : "Not a Palindrome");
        return 0;
    }
}