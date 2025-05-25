package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Constructor;
import dev.anthonybruno.f1.api.model.ConstructorResponse;
import dev.anthonybruno.f1.api.model.MRData;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ConstructorsClient {
    private static final String BASE_ENDPOINT = "/ergast/f1/constructors/";
    private final F1ApiClient apiClient;

    public ConstructorsClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Constructor> getAllConstructors() throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT;
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Constructor> getConstructorsBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/constructors/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Constructor> getConstructorsByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/constructors/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public Constructor getConstructorById(String constructorId) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + constructorId + "/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null && response.mrData().constructorTable().constructors() != null && !response.mrData().constructorTable().constructors().isEmpty()) {
                return response.mrData().constructorTable().constructors().get(0);
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Constructor> getConstructorsByCircuit(String circuitId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/circuits/" + circuitId + "/constructors/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Constructor> getConstructorsByDriver(String driverId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/drivers/" + driverId + "/constructors/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Constructor> getConstructorsByGridPosition(String gridPosition) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/grid/" + gridPosition + "/constructors/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Constructor> getConstructorsByResultPosition(String resultPosition) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/results/" + resultPosition + "/constructors/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Constructor> getConstructorsByStatus(String statusId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/status/" + statusId + "/constructors/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public List<Constructor> getConstructorsByFastestLap(String lapRank) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/fastest/" + lapRank + "/constructors/";
        String json = apiClient.get(endpoint);
        try {
            ConstructorResponse response = JsonUtils.fromJson(json, ConstructorResponse.class);
            if (response != null && response.mrData() != null && response.mrData().constructorTable() != null) {
                return response.mrData().constructorTable().constructors();
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor response: " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }
} 