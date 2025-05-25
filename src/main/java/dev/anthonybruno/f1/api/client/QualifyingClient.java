package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.QualifyingResult;
import dev.anthonybruno.f1.api.model.QualifyingResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class QualifyingClient {
    private final F1ApiClient apiClient;

    public QualifyingClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<QualifyingResult> getQualifyingBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/qualifying/";
        String json = apiClient.get(endpoint);
        try {
            QualifyingResponse response = JsonUtils.fromJson(json, QualifyingResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.qualifyingResults() != null)
                        .flatMap(r -> r.qualifyingResults().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing qualifying response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<QualifyingResult> getQualifyingByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/qualifying/";
        String json = apiClient.get(endpoint);
        try {
            QualifyingResponse response = JsonUtils.fromJson(json, QualifyingResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.qualifyingResults() != null)
                        .flatMap(r -> r.qualifyingResults().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing qualifying response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<QualifyingResult> getQualifyingByDriver(String driverId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/drivers/" + driverId + "/qualifying/";
        String json = apiClient.get(endpoint);
        try {
            QualifyingResponse response = JsonUtils.fromJson(json, QualifyingResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.qualifyingResults() != null)
                        .flatMap(r -> r.qualifyingResults().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing qualifying response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<QualifyingResult> getQualifyingByConstructor(String constructorId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/constructors/" + constructorId + "/qualifying/";
        String json = apiClient.get(endpoint);
        try {
            QualifyingResponse response = JsonUtils.fromJson(json, QualifyingResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.qualifyingResults() != null)
                        .flatMap(r -> r.qualifyingResults().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing qualifying response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<QualifyingResult> getQualifyingByCircuit(String circuitId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/circuits/" + circuitId + "/qualifying/";
        String json = apiClient.get(endpoint);
        try {
            QualifyingResponse response = JsonUtils.fromJson(json, QualifyingResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.qualifyingResults() != null)
                        .flatMap(r -> r.qualifyingResults().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing qualifying response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 