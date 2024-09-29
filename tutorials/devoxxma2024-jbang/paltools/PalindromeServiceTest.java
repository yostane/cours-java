///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.junit.jupiter:junit-jupiter-api:5.10.0
//DEPS org.junit.jupiter:junit-jupiter-engine:5.10.0
//DEPS org.junit.platform:junit-platform-launcher:1.10.0

//SOURCES PalindromeService.java

import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.LoggingListener;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

// JUnit5 Test class for PalindromeService
public class PalindromeServiceTest {

    // Define each Unit test here and run them separately in the IDE
    @Test
    public void testPalindromeService() {
        assertEquals(PalindromeService.isPalindrome("madam"), true);
        assertEquals(PalindromeService.isPalindrome("mama"), false);
    }

    // Run all Unit tests with JBang with ./PalindromeService.java
    public static void main(final String... args) {
        final LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(PalindromeServiceTest.class))
                .build();
        final Launcher launcher = LauncherFactory.create();
        final LoggingListener logListener = LoggingListener.forBiConsumer((t, m) -> {
            System.out.println(m.get());
            if (t != null) {
                t.printStackTrace();
            }
            ;
        });
        final SummaryGeneratingListener execListener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(execListener, logListener);
        launcher.execute(request);
        execListener.getSummary().printTo(new java.io.PrintWriter(out));
    }
}
