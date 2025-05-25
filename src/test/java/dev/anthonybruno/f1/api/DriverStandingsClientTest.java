package dev.anthonybruno.f1.api;

import dev.anthonybruno.f1.api.client.DriverStandingsClient;
import dev.anthonybruno.f1.api.client.F1ApiClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DriverStandingsClientTest {

    @Test
    public void testDriverStandingsClient() throws IOException, InterruptedException {
        // Create a new F1ApiClient
        F1ApiClient apiClient = new F1ApiClient();

        // Create a DriverStandingsClient using the F1ApiClient
        DriverStandingsClient driverStandingsClient = new DriverStandingsClient(apiClient);

        var driverStandings = driverStandingsClient.getDriverStandingsBySeason("2023");

        // Verify that the DriverStandingsClient was created successfully
        assertNotNull(driverStandings, "DriverStandingsClient should not be null");
    }
}