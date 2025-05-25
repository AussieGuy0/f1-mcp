package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Status;
import dev.anthonybruno.f1.api.model.StatusResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class StatusClient {
    private final F1ApiClient apiClient;

    public StatusClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Status> getAllStatus() throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/status/";
        String json = apiClient.get(endpoint);
        try {
            StatusResponse response = JsonUtils.fromJson(json, StatusResponse.class);
            if (response != null && response.mrData() != null && response.mrData().statusTable() != null) {
                return response.mrData().statusTable().status();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing status response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 