package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a driver's standing in the championship.
 */
public record DriverStanding(
        @JsonProperty("position") String position,
        @JsonProperty("positionText") String positionText,
        @JsonProperty("points") String points,
        @JsonProperty("wins") String wins,
        @JsonProperty("Driver") Driver driver,
        @JsonProperty("Constructors") List<Constructor> constructors) {
}