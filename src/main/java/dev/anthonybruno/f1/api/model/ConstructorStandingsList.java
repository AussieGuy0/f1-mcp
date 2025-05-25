package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a list of constructor standings for a specific season and round.
 */
public record ConstructorStandingsList(
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("ConstructorStandings") List<ConstructorStanding> constructorStandings) {
}