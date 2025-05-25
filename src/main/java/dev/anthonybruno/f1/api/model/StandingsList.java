package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a list of driver standings for a specific season and round.
 */
public record StandingsList(
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("DriverStandings") List<DriverStanding> driverStandings) {
}