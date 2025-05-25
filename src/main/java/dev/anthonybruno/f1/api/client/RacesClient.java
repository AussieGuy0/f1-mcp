package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Race;
import dev.anthonybruno.f1.api.model.RacesResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class RacesClient {
    private final F1ApiClient apiClient;

    public RacesClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Race> getAllRaces() throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/races/";
        String json = apiClient.get(endpoint);
        try {
            RacesResponse response = JsonUtils.fromJson(json, RacesResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null) {
                return response.mrData().raceTable().races();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing races response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Race> getRacesBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/races/";
        String json = apiClient.get(endpoint);
        try {
            RacesResponse response = JsonUtils.fromJson(json, RacesResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null) {
                return response.mrData().raceTable().races();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing races response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Race> getRacesByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/races/";
        String json = apiClient.get(endpoint);
        try {
            RacesResponse response = JsonUtils.fromJson(json, RacesResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null) {
                return response.mrData().raceTable().races();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing races response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Race> getRacesByCircuit(String circuitId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/circuits/" + circuitId + "/races/";
        String json = apiClient.get(endpoint);
        try {
            RacesResponse response = JsonUtils.fromJson(json, RacesResponse.class);
            // TODO: Extract races from MRData
        } catch (Exception e) {
            throw new IOException("Error parsing races response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Race> getRacesByConstructor(String constructorId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/constructors/" + constructorId + "/races/";
        String json = apiClient.get(endpoint);
        try {
            RacesResponse response = JsonUtils.fromJson(json, RacesResponse.class);
            // TODO: Extract races from MRData
        } catch (Exception e) {
            throw new IOException("Error parsing races response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Race> getRacesByDriver(String driverId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/drivers/" + driverId + "/races/";
        String json = apiClient.get(endpoint);
        try {
            RacesResponse response = JsonUtils.fromJson(json, RacesResponse.class);
            // TODO: Extract races from MRData
        } catch (Exception e) {
            throw new IOException("Error parsing races response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Race> getRacesByGridPosition(String gridPosition) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/grid/" + gridPosition + "/races/";
        String json = apiClient.get(endpoint);
        try {
            RacesResponse response = JsonUtils.fromJson(json, RacesResponse.class);
            // TODO: Extract races from MRData
        } catch (Exception e) {
            throw new IOException("Error parsing races response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Race> getRacesByStatus(String statusId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/status/" + statusId + "/races/";
        String json = apiClient.get(endpoint);
        try {
            RacesResponse response = JsonUtils.fromJson(json, RacesResponse.class);
            // TODO: Extract races from MRData
        } catch (Exception e) {
            throw new IOException("Error parsing races response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 