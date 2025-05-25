package dev.anthonybruno.f1.api;

import dev.anthonybruno.f1.api.client.DriversClient;
import dev.anthonybruno.f1.api.client.F1ApiClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DriversClientTest {

    @Test
    public void testDriversClient() throws IOException, InterruptedException {
        // Create a new F1ApiClient
        F1ApiClient apiClient = new F1ApiClient();

        // Create a DriversClient using the F1ApiClient
        DriversClient driversClient = new DriversClient(apiClient);

        var drivers = driversClient.getAllDrivers();

        // Verify that the DriversClient was created successfully
        assertNotNull(drivers, "DriversClient should not be null");
    }
}