package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.DriverStanding;
import dev.anthonybruno.f1.api.model.DriverStandingsResponse;
import dev.anthonybruno.f1.api.model.MRData;
import dev.anthonybruno.f1.api.model.StandingsList;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Client for interacting with the driver standings endpoint of the F1 API.
 */
public class DriverStandingsClient {
    private static final String BASE_ENDPOINT = "/ergast/f1/";

    private final F1ApiClient apiClient;

    /**
     * Creates a new DriverStandingsClient with the specified API client.
     *
     * @param apiClient the API client to use
     */
    public DriverStandingsClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Gets driver standings for a specific season.
     *
     * @param season the season year or "current" for the current season
     * @return a list of driver standings for the specified season
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<DriverStanding> getDriverStandingsBySeason(String season) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + season + "/driverstandings/";
        String json = apiClient.get(endpoint);

        try {
            DriverStandingsResponse response = JsonUtils.fromJson(json, DriverStandingsResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.standingsTable() != null && data.standingsTable().standingsLists() != null && !data.standingsTable().standingsLists().isEmpty()) {
                    StandingsList standingsList = data.standingsTable().standingsLists().get(0);
                    if (standingsList != null && standingsList.driverStandings() != null) {
                        return standingsList.driverStandings();
                    }
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver standings response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets driver standings for a specific round of a season.
     *
     * @param season the season year or "current" for the current season
     * @param round the round number or "last"
     * @return a list of driver standings for the specified round
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<DriverStanding> getDriverStandingsByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + season + "/" + round + "/driverstandings/";
        String json = apiClient.get(endpoint);

        try {
            DriverStandingsResponse response = JsonUtils.fromJson(json, DriverStandingsResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.standingsTable() != null && data.standingsTable().standingsLists() != null && !data.standingsTable().standingsLists().isEmpty()) {
                    StandingsList standingsList = data.standingsTable().standingsLists().get(0);
                    if (standingsList != null && standingsList.driverStandings() != null) {
                        return standingsList.driverStandings();
                    }
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver standings response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets driver standings for a specific driver in a season.
     *
     * @param season the season year or "current" for the current season
     * @param driverId the ID of the driver
     * @return a list of driver standings for the specified driver
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<DriverStanding> getDriverStandingsByDriver(String season, String driverId) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + season + "/drivers/" + driverId + "/driverstandings/";
        String json = apiClient.get(endpoint);

        try {
            DriverStandingsResponse response = JsonUtils.fromJson(json, DriverStandingsResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.standingsTable() != null && data.standingsTable().standingsLists() != null && !data.standingsTable().standingsLists().isEmpty()) {
                    StandingsList standingsList = data.standingsTable().standingsLists().get(0);
                    if (standingsList != null && standingsList.driverStandings() != null) {
                        return standingsList.driverStandings();
                    }
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver standings response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets driver standings for a specific position in a season.
     *
     * @param season the season year or "current" for the current season
     * @param position the position in the standings
     * @return a list of driver standings for the specified position
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<DriverStanding> getDriverStandingsByPosition(String season, String position) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + season + "/driverstandings/" + position + "/";
        String json = apiClient.get(endpoint);

        try {
            DriverStandingsResponse response = JsonUtils.fromJson(json, DriverStandingsResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.standingsTable() != null && data.standingsTable().standingsLists() != null && !data.standingsTable().standingsLists().isEmpty()) {
                    StandingsList standingsList = data.standingsTable().standingsLists().get(0);
                    if (standingsList != null && standingsList.driverStandings() != null) {
                        return standingsList.driverStandings();
                    }
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver standings response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }
}
