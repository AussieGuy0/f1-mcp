package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a table of driver standings in the F1 API response.
 */
public record StandingsTable(
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("driverId") String driverId,
        @JsonProperty("constructorId") String constructorId,
        @JsonProperty("StandingsLists") List<StandingsList> standingsLists) {
}