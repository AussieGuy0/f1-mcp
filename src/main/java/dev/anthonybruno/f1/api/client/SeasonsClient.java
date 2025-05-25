package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Season;
import dev.anthonybruno.f1.api.model.SeasonsResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SeasonsClient {
    private final F1ApiClient apiClient;

    public SeasonsClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Season> getAllSeasons() throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/seasons/";
        String json = apiClient.get(endpoint);
        try {
            SeasonsResponse response = JsonUtils.fromJson(json, SeasonsResponse.class);
            if (response != null && response.mrData() != null && response.mrData().seasonsTable() != null) {
                return response.mrData().seasonsTable().seasons();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing seasons response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 