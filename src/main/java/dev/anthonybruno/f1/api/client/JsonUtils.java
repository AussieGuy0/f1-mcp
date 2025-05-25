package dev.anthonybruno.f1.api.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * Utility class for JSON parsing.
 */
public class JsonUtils {

    /**
     * Parses a JSON string into an object of the specified type.
     *
     * @param json the JSON string to parse
     * @param clazz the class of the object to parse into
     * @param <T> the type of the object
     * @return the parsed object
     * @throws IOException if an error occurs during parsing
     */
    private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> T fromJson(String json, Class<T> clazz) throws IOException {
        if (json == null || json.isEmpty()) {
            return null;
        }

        return objectMapper.readValue(json, clazz);
    }

    /**
     * Converts an object to a JSON string.
     *
     * @param object the object to convert
     * @return the JSON string
     * @throws IOException if an error occurs during conversion
     */
    public static String toJson(Object object) throws IOException {
        if (object == null) {
            return "null";
        }

        return objectMapper.writeValueAsString(object);
    }
}
