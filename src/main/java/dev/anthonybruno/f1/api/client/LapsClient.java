package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Lap;
import dev.anthonybruno.f1.api.model.LapsResponse;
import dev.anthonybruno.f1.api.model.MRData;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class LapsClient {
    private final F1ApiClient apiClient;

    public LapsClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Lap> getLapsBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/laps/";
        String json = apiClient.get(endpoint);
        try {
            LapsResponse response = JsonUtils.fromJson(json, LapsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.laps() != null)
                        .flatMap(r -> r.laps().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing laps response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Lap> getLapsByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/laps/";
        String json = apiClient.get(endpoint);
        try {
            LapsResponse response = JsonUtils.fromJson(json, LapsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.laps() != null)
                        .flatMap(r -> r.laps().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing laps response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Lap> getLapsByDriver(String driverId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/drivers/" + driverId + "/laps/";
        String json = apiClient.get(endpoint);
        try {
            LapsResponse response = JsonUtils.fromJson(json, LapsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.laps() != null)
                        .flatMap(r -> r.laps().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing laps response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Lap> getLapsByConstructor(String constructorId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/constructors/" + constructorId + "/laps/";
        String json = apiClient.get(endpoint);
        try {
            LapsResponse response = JsonUtils.fromJson(json, LapsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.laps() != null)
                        .flatMap(r -> r.laps().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing laps response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Lap> getLapsByCircuit(String circuitId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/circuits/" + circuitId + "/laps/";
        String json = apiClient.get(endpoint);
        try {
            LapsResponse response = JsonUtils.fromJson(json, LapsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.laps() != null)
                        .flatMap(r -> r.laps().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing laps response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Lap> getLapsByLapNumber(String lapNumber) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/laps/" + lapNumber + "/";
        String json = apiClient.get(endpoint);
        try {
            LapsResponse response = JsonUtils.fromJson(json, LapsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.laps() != null)
                        .flatMap(r -> r.laps().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing laps response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 