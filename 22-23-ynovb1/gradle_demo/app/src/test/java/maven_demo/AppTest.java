/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package maven_demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
        assertEquals("Hello World!", classUnderTest.getGreeting());
    }

    @Test
    void appDivides() {
        assertDoesNotThrow(() -> {
            assertEquals(10, App.divide(100, 10));
        });
    }

    @Test
    void appCannotDivideBy0() {
        assertThrows(ZeroException.class, () -> {
            App.divide(100, 0);
        });
    }
}