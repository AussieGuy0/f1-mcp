package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a table of constructor standings in the F1 API response.
 */
public record ConstructorStandingsTable(
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("constructorId") String constructorId,
        @JsonProperty("StandingsLists") List<ConstructorStandingsList> standingsLists) {
}