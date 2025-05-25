package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Pitstop;
import dev.anthonybruno.f1.api.model.PitstopsResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PitstopsClient {
    private final F1ApiClient apiClient;

    public PitstopsClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Pitstop> getPitstopsBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/pitstops/";
        String json = apiClient.get(endpoint);
        try {
            PitstopsResponse response = JsonUtils.fromJson(json, PitstopsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.pitstops() != null)
                        .flatMap(r -> r.pitstops().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing pitstops response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Pitstop> getPitstopsByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/pitstops/";
        String json = apiClient.get(endpoint);
        try {
            PitstopsResponse response = JsonUtils.fromJson(json, PitstopsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.pitstops() != null)
                        .flatMap(r -> r.pitstops().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing pitstops response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Pitstop> getPitstopsByDriver(String driverId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/drivers/" + driverId + "/pitstops/";
        String json = apiClient.get(endpoint);
        try {
            PitstopsResponse response = JsonUtils.fromJson(json, PitstopsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.pitstops() != null)
                        .flatMap(r -> r.pitstops().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing pitstops response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Pitstop> getPitstopsByConstructor(String constructorId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/constructors/" + constructorId + "/pitstops/";
        String json = apiClient.get(endpoint);
        try {
            PitstopsResponse response = JsonUtils.fromJson(json, PitstopsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.pitstops() != null)
                        .flatMap(r -> r.pitstops().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing pitstops response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Pitstop> getPitstopsByCircuit(String circuitId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/circuits/" + circuitId + "/pitstops/";
        String json = apiClient.get(endpoint);
        try {
            PitstopsResponse response = JsonUtils.fromJson(json, PitstopsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.pitstops() != null)
                        .flatMap(r -> r.pitstops().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing pitstops response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 