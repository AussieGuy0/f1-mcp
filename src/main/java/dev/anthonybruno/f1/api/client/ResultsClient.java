package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Result;
import dev.anthonybruno.f1.api.model.ResultsResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ResultsClient {
    private final F1ApiClient apiClient;

    public ResultsClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Result> getResultsBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/results/";
        String json = apiClient.get(endpoint);
        try {
            ResultsResponse response = JsonUtils.fromJson(json, ResultsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.results() != null)
                        .flatMap(r -> r.results().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing results response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Result> getResultsByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/results/";
        String json = apiClient.get(endpoint);
        try {
            ResultsResponse response = JsonUtils.fromJson(json, ResultsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.results() != null)
                        .flatMap(r -> r.results().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing results response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Result> getResultsByDriver(String driverId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/drivers/" + driverId + "/results/";
        String json = apiClient.get(endpoint);
        try {
            ResultsResponse response = JsonUtils.fromJson(json, ResultsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.results() != null)
                        .flatMap(r -> r.results().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing results response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Result> getResultsByConstructor(String constructorId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/constructors/" + constructorId + "/results/";
        String json = apiClient.get(endpoint);
        try {
            ResultsResponse response = JsonUtils.fromJson(json, ResultsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.results() != null)
                        .flatMap(r -> r.results().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing results response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Result> getResultsByCircuit(String circuitId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/circuits/" + circuitId + "/results/";
        String json = apiClient.get(endpoint);
        try {
            ResultsResponse response = JsonUtils.fromJson(json, ResultsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.results() != null)
                        .flatMap(r -> r.results().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing results response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Result> getResultsByGridPosition(String gridPosition) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/grid/" + gridPosition + "/results/";
        String json = apiClient.get(endpoint);
        try {
            ResultsResponse response = JsonUtils.fromJson(json, ResultsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.results() != null)
                        .flatMap(r -> r.results().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing results response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Result> getResultsByStatus(String statusId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/status/" + statusId + "/results/";
        String json = apiClient.get(endpoint);
        try {
            ResultsResponse response = JsonUtils.fromJson(json, ResultsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.results() != null)
                        .flatMap(r -> r.results().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing results response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Result> getResultsByFastestLap(String lapRank) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/fastest/" + lapRank + "/results/";
        String json = apiClient.get(endpoint);
        try {
            ResultsResponse response = JsonUtils.fromJson(json, ResultsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.results() != null)
                        .flatMap(r -> r.results().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing results response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 