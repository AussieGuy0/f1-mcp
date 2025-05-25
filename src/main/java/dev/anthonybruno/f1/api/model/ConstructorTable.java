package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a table of constructors in the F1 API response.
 */
public record ConstructorTable(
        @JsonProperty("Constructors") List<Constructor> constructors,
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("circuitId") String circuitId,
        @JsonProperty("driverId") String driverId,
        @JsonProperty("constructorId") String constructorId,
        @JsonProperty("position") String position,
        @JsonProperty("grid") String grid,
        @JsonProperty("statusId") String statusId) {
}