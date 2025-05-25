package dev.anthonybruno.f1.api;

import dev.anthonybruno.f1.api.client.ConstructorsClient;
import dev.anthonybruno.f1.api.client.F1ApiClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructorsClientTest {

    @Test
    public void testConstructorsClient() throws IOException, InterruptedException {
        // Create a new F1ApiClient
        F1ApiClient apiClient = new F1ApiClient();

        // Create a ConstructorsClient using the F1ApiClient
        ConstructorsClient constructorsClient = new ConstructorsClient(apiClient);

        var constructors = constructorsClient.getAllConstructors();

        // Verify that the ConstructorsClient was created successfully
        assertNotNull(constructors, "Constructors list should not be null");
    }
}