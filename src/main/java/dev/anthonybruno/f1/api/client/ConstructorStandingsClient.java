package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.ConstructorStanding;
import dev.anthonybruno.f1.api.model.ConstructorStandingsResponse;
import dev.anthonybruno.f1.api.model.ConstructorStandingsList;
import dev.anthonybruno.f1.api.model.MRData;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Client for interacting with the constructor standings endpoint of the F1 API.
 */
public class ConstructorStandingsClient {
    private static final String BASE_ENDPOINT = "/ergast/f1/";
    
    private final F1ApiClient apiClient;
    
    /**
     * Creates a new ConstructorStandingsClient with the specified API client.
     *
     * @param apiClient the API client to use
     */
    public ConstructorStandingsClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    /**
     * Gets constructor standings for a specific season.
     *
     * @param season the season year or "current" for the current season
     * @return a list of constructor standings for the specified season
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<ConstructorStanding> getConstructorStandingsBySeason(String season) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + season + "/constructorstandings/";
        String json = apiClient.get(endpoint);
        
        try {
            ConstructorStandingsResponse response = JsonUtils.fromJson(json, ConstructorStandingsResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.constructorStandingsTable() != null && data.constructorStandingsTable().standingsLists() != null && !data.constructorStandingsTable().standingsLists().isEmpty()) {
                    ConstructorStandingsList standingsList = data.constructorStandingsTable().standingsLists().get(0);
                    if (standingsList != null && standingsList.constructorStandings() != null) {
                        return standingsList.constructorStandings();
                    }
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor standings response: " + e.getMessage(), e);
        }
        
        return Collections.emptyList();
    }
    
    /**
     * Gets constructor standings for a specific round of a season.
     *
     * @param season the season year or "current" for the current season
     * @param round the round number or "last"
     * @return a list of constructor standings for the specified round
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<ConstructorStanding> getConstructorStandingsByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + season + "/" + round + "/constructorstandings/";
        String json = apiClient.get(endpoint);
        
        try {
            ConstructorStandingsResponse response = JsonUtils.fromJson(json, ConstructorStandingsResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.constructorStandingsTable() != null && data.constructorStandingsTable().standingsLists() != null && !data.constructorStandingsTable().standingsLists().isEmpty()) {
                    ConstructorStandingsList standingsList = data.constructorStandingsTable().standingsLists().get(0);
                    if (standingsList != null && standingsList.constructorStandings() != null) {
                        return standingsList.constructorStandings();
                    }
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor standings response: " + e.getMessage(), e);
        }
        
        return Collections.emptyList();
    }
    
    /**
     * Gets constructor standings for a specific constructor in a season.
     *
     * @param season the season year or "current" for the current season
     * @param constructorId the ID of the constructor
     * @return a list of constructor standings for the specified constructor
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<ConstructorStanding> getConstructorStandingsByConstructor(String season, String constructorId) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + season + "/constructors/" + constructorId + "/constructorstandings/";
        String json = apiClient.get(endpoint);
        
        try {
            ConstructorStandingsResponse response = JsonUtils.fromJson(json, ConstructorStandingsResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.constructorStandingsTable() != null && data.constructorStandingsTable().standingsLists() != null && !data.constructorStandingsTable().standingsLists().isEmpty()) {
                    ConstructorStandingsList standingsList = data.constructorStandingsTable().standingsLists().get(0);
                    if (standingsList != null && standingsList.constructorStandings() != null) {
                        return standingsList.constructorStandings();
                    }
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor standings response: " + e.getMessage(), e);
        }
        
        return Collections.emptyList();
    }
    
    /**
     * Gets constructor standings for a specific position in a season.
     *
     * @param season the season year or "current" for the current season
     * @param position the position in the standings
     * @return a list of constructor standings for the specified position
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<ConstructorStanding> getConstructorStandingsByPosition(String season, String position) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + season + "/constructorstandings/" + position + "/";
        String json = apiClient.get(endpoint);
        
        try {
            ConstructorStandingsResponse response = JsonUtils.fromJson(json, ConstructorStandingsResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.constructorStandingsTable() != null && data.constructorStandingsTable().standingsLists() != null && !data.constructorStandingsTable().standingsLists().isEmpty()) {
                    ConstructorStandingsList standingsList = data.constructorStandingsTable().standingsLists().get(0);
                    if (standingsList != null && standingsList.constructorStandings() != null) {
                        return standingsList.constructorStandings();
                    }
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing constructor standings response: " + e.getMessage(), e);
        }
        
        return Collections.emptyList();
    }
}