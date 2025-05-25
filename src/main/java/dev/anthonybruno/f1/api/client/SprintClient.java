package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Sprint;
import dev.anthonybruno.f1.api.model.SprintResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SprintClient {
    private final F1ApiClient apiClient;

    public SprintClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Sprint> getSprintBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/sprint/";
        String json = apiClient.get(endpoint);
        try {
            SprintResponse response = JsonUtils.fromJson(json, SprintResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.sprintResults() != null)
                        .flatMap(r -> r.sprintResults().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing sprint response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Sprint> getSprintByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/sprint/";
        String json = apiClient.get(endpoint);
        try {
            SprintResponse response = JsonUtils.fromJson(json, SprintResponse.class);
            if (response != null && response.mrData() != null && response.mrData().raceTable() != null && response.mrData().raceTable().races() != null) {
                return response.mrData().raceTable().races().stream()
                        .filter(r -> r != null && r.sprintResults() != null)
                        .flatMap(r -> r.sprintResults().stream())
                        .toList();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing sprint response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 