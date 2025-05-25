package dev.anthonybruno.f1.api;

import dev.anthonybruno.f1.api.client.CircuitsClient;
import dev.anthonybruno.f1.api.client.F1ApiClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class CircuitsClientTest {


    @Test
    public void testCircuitsClient() throws IOException, InterruptedException {
        // Create a new F1ApiClient
        F1ApiClient apiClient = new F1ApiClient();

        // Create a CircuitsClient using the F1ApiClient
        CircuitsClient circuitsClient = new CircuitsClient(apiClient);

        var circuits = circuitsClient.getAllCircuits();

        // Verify that the CircuitsClient was created successfully
        assertNotNull(circuits, "CircuitsClient should not be null");
    }
}
