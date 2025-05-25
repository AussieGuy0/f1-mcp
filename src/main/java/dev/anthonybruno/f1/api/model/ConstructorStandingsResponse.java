package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the response from the constructor standings endpoint.
 */
public record ConstructorStandingsResponse(
        @JsonProperty("MRData") MRData mrData) {
}