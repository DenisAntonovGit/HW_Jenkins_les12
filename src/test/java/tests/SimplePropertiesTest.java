package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SimplePropertiesTest {

    @Test
    @Tag("hello")
    void simpleProperiesTest() {
        System.out.println("Hello, " + System.getProperty("user_name", "unknown student"));
    }
}
