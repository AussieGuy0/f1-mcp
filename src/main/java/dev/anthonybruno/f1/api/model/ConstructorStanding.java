package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a constructor's standing in the championship.
 */
public record ConstructorStanding(
        @JsonProperty("position") String position,
        @JsonProperty("positionText") String positionText,
        @JsonProperty("points") String points,
        @JsonProperty("wins") String wins,
        @JsonProperty("Constructor") Constructor constructor) {
}