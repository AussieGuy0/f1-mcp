package dev.anthonybruno.f1.api.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Main client class for interacting with the F1 API.
 * This class provides the core functionality for making API requests.
 */
public class F1ApiClient {
    private static final String DEFAULT_BASE_URL = "https://api.jolpi.ca";
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(30);
    
    private final HttpClient httpClient;
    private final String baseUrl;
    
    /**
     * Creates a new F1ApiClient with default configuration.
     */
    public F1ApiClient() {
        this(DEFAULT_BASE_URL);
    }
    
    /**
     * Creates a new F1ApiClient with the specified base URL.
     *
     * @param baseUrl the base URL for the API
     */
    public F1ApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(DEFAULT_TIMEOUT)
                .build();
    }
    
    /**
     * Sends a GET request to the specified endpoint.
     *
     * @param endpoint the API endpoint to call
     * @return the response body as a string
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    String get(String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(baseUrl + endpoint))
                .header("Accept", "application/json")
                .build();

        System.out.println(request);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            return response.body();
        } else {
            throw new IOException("Unexpected response status: " + response.statusCode());
        }
    }
    
    /**
     * Returns a CircuitsClient for accessing circuits endpoints.
     */
    public CircuitsClient circuitsClient() {
        return new CircuitsClient(this);
    }

    /**
     * Returns a DriversClient for accessing drivers endpoints.
     */
    public DriversClient driversClient() {
        return new DriversClient(this);
    }

    /**
     * Returns a DriverStandingsClient for accessing driver standings endpoints.
     */
    public DriverStandingsClient driverStandingsClient() {
        return new DriverStandingsClient(this);
    }

    /**
     * Returns a ConstructorStandingsClient for accessing constructor standings endpoints.
     */
    public ConstructorStandingsClient constructorStandingsClient() {
        return new ConstructorStandingsClient(this);
    }
}