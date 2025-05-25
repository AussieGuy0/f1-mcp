package dev.anthonybruno.f1.api;

import dev.anthonybruno.f1.api.client.JsonUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

/**
 * Unit test for JsonUtils.
 */
public class JsonUtilsTest {

    /**
     * Test case for the JsonUtils class.
     * 
     * This test verifies that the JSON parsing and serialization work correctly using Jackson.
     */
    @Test
    public void testJsonUtils() throws IOException {
        // Test object to JSON
        TestObject testObject = new TestObject("test", 123);
        String json = JsonUtils.toJson(testObject);

        // Verify JSON contains expected values
        assertTrue(json.contains("\"name\":\"test\""), "JSON should contain name field");
        assertTrue(json.contains("\"value\":123"), "JSON should contain value field");

        // Test JSON to object
        TestObject parsedObject = JsonUtils.fromJson(json, TestObject.class);

        // Verify parsed object has correct values
        assertEquals("test", parsedObject.getName(), "Name should match original object");
        assertEquals(123, parsedObject.getValue(), "Value should match original object");

        // Test null handling
        assertNull(JsonUtils.fromJson(null, TestObject.class), "fromJson with null should return null");
        assertEquals("null", JsonUtils.toJson(null), "toJson with null should return 'null' string");
    }

    /**
     * Simple test class for JSON serialization/deserialization.
     */
    public static class TestObject {
        private String name;
        private int value;

        // Default constructor needed for Jackson
        public TestObject() {
        }

        public TestObject(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
