package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the response from the driver standings endpoint.
 */
public record DriverStandingsResponse(
        @JsonProperty("MRData") MRData mrData) {
}