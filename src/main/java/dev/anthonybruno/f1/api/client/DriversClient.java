package dev.anthonybruno.f1.api.client;

import dev.anthonybruno.f1.api.model.Driver;
import dev.anthonybruno.f1.api.model.DriverResponse;
import dev.anthonybruno.f1.api.model.MRData;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Client for interacting with the drivers endpoint of the F1 API.
 */
public class DriversClient {
    private static final String BASE_ENDPOINT = "/ergast/f1/drivers/";

    private final F1ApiClient apiClient;

    /**
     * Creates a new DriversClient with the specified API client.
     *
     * @param apiClient the API client to use
     */
    public DriversClient(F1ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Gets all drivers.
     *
     * @return a list of all drivers
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getAllDrivers() throws IOException, InterruptedException {
        return getAllDrivers(0, 30);
    }

    /**
     * Gets all drivers with pagination.
     *
     * @param offset the offset for pagination
     * @param limit the maximum number of results to return
     * @return a list of drivers
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getAllDrivers(int offset, int limit) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + "?offset=" + offset + "&limit=" + limit;
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null) {
                    return data.driverTable().drivers();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets drivers for a specific season.
     *
     * @param season the season year or "current" for the current season
     * @return a list of drivers for the specified season
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getDriversBySeason(String season) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/drivers/";
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null) {
                    return data.driverTable().drivers();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets a specific driver by ID.
     *
     * @param driverId the ID of the driver
     * @return the driver, or null if not found
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public Driver getDriverById(String driverId) throws IOException, InterruptedException {
        String endpoint = BASE_ENDPOINT + driverId + "/";
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null && !data.driverTable().drivers().isEmpty()) {
                    return data.driverTable().drivers().get(0);
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return null;
    }

    /**
     * Gets drivers for a specific round of a season.
     *
     * @param season the season year or "current" for the current season
     * @param round the round number or "last"
     * @return a list of drivers for the specified round
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getDriversByRound(String season, String round) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/" + season + "/" + round + "/drivers/";
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null) {
                    return data.driverTable().drivers();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets drivers for a specific circuit.
     *
     * @param circuitId the ID of the circuit
     * @return a list of drivers for the specified circuit
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getDriversByCircuit(String circuitId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/circuits/" + circuitId + "/drivers/";
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null) {
                    return data.driverTable().drivers();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets drivers for a specific constructor.
     *
     * @param constructorId the ID of the constructor
     * @return a list of drivers for the specified constructor
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getDriversByConstructor(String constructorId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/constructors/" + constructorId + "/drivers/";
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null) {
                    return data.driverTable().drivers();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets drivers who have achieved a specific grid position.
     *
     * @param gridPosition the grid position
     * @return a list of drivers who have achieved the specified grid position
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getDriversByGridPosition(String gridPosition) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/grid/" + gridPosition + "/drivers/";
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null) {
                    return data.driverTable().drivers();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets drivers who have achieved a specific result position.
     *
     * @param resultPosition the result position
     * @return a list of drivers who have achieved the specified result position
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getDriversByResultPosition(String resultPosition) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/results/" + resultPosition + "/drivers/";
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null) {
                    return data.driverTable().drivers();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    /**
     * Gets drivers who have achieved a specific status.
     *
     * @param statusId the status ID
     * @return a list of drivers who have achieved the specified status
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public List<Driver> getDriversByStatus(String statusId) throws IOException, InterruptedException {
        String endpoint = "/ergast/f1/status/" + statusId + "/drivers/";
        String json = apiClient.get(endpoint);

        try {
            DriverResponse response = JsonUtils.fromJson(json, DriverResponse.class);
            if (response != null && response.mrData() != null) {
                MRData data = response.mrData();
                if (data.driverTable() != null && data.driverTable().drivers() != null) {
                    return data.driverTable().drivers();
                }
            }
        } catch (Exception e) {
            throw new IOException("Error parsing driver response: " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }
}
