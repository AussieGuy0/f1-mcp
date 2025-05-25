package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a table of drivers in the F1 API response.
 */
public record DriverTable(
        @JsonProperty("Drivers") List<Driver> drivers,
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("circuitId") String circuitId,
        @JsonProperty("constructorId") String constructorId,
        @JsonProperty("driverId") String driverId,
        @JsonProperty("position") String position,
        @JsonProperty("grid") String grid,
        @JsonProperty("statusId") String statusId) {
}