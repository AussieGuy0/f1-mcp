package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Circuit;
import dev.anthonybruno.f1.api.model.CircuitResponse;
import dev.anthonybruno.f1.api.model.MRData;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Client for interacting with the circuits endpoint of the F1 API.
 */
public class CircuitsClient {
    private static final String BASE_ENDPOINT = "/ergast/f1/circuits/";
    
    private final F1ApiClient apiClient;
    
    /**
     * Creates a new CircuitsClient with the specified API client.
     *
     * @param apiClient the API client to use
     */
    public CircuitsClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    /**
     * Gets all circuits.
     *
     * @return a list of all circuits
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Circuit> getAllCircuits() throws IOException, InterruptedException {
        return getAllCircuits(0, 30);
    }
    
    /**
     * Gets all circuits with pagination.
     *
     * @param offset the offset for pagination
     * @param limit the maximum number of results to return
     * @return a list of circuits
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Circuit> getAllCircuits(int offset, int limit) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + "?offset=" + offset + "&limit=" + limit;
        String json = apiClient.get(endpoint);
        
        try {
            CircuitResponse response = JsonUtils.fromJson(json, CircuitResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.circuitTable() != null && data.circuitTable().circuits() != null) {
                    return data.circuitTable().circuits();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing circuit response: " + e.getMessage(), e);
        }
        
        return Collections.emptyList();
    }
    
    /**
     * Gets circuits for a specific season.
     *
     * @param season the season year or "current" for the current season
     * @return a list of circuits for the specified season
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Circuit> getCircuitsBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/circuits.json";
        String json = apiClient.get(endpoint);
        
        try {
            CircuitResponse response = JsonUtils.fromJson(json, CircuitResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.circuitTable() != null && data.circuitTable().circuits() != null) {
                    return data.circuitTable().circuits();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing circuit response: " + e.getMessage(), e);
        }
        
        return Collections.emptyList();
    }
    
    /**
     * Gets a specific circuit by ID.
     *
     * @param circuitId the ID of the circuit
     * @return the circuit, or null if not found
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public Circuit getCircuitById(String circuitId) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + circuitId + ".json";
        String json = apiClient.get(endpoint);
        
        try {
            CircuitResponse response = JsonUtils.fromJson(json, CircuitResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.circuitTable() != null && data.circuitTable().circuits() != null && !data.circuitTable().circuits().isEmpty()) {
                    return data.circuitTable().circuits().get(0);
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing circuit response: " + e.getMessage(), e);
        }
        
        return null;
    }
    
    /**
     * Gets circuits for a specific round of a season.
     *
     * @param season the season year or "current" for the current season
     * @param round the round number or "last" or "next"
     * @return a list of circuits for the specified round
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Circuit> getCircuitsByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/circuits.json";
        String json = apiClient.get(endpoint);
        
        try {
            CircuitResponse response = JsonUtils.fromJson(json, CircuitResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.circuitTable() != null && data.circuitTable().circuits() != null) {
                    return data.circuitTable().circuits();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing circuit response: " + e.getMessage(), e);
        }
        
        return Collections.emptyList();
    }
}