package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the response from the drivers endpoint.
 */
public record DriverResponse(
        @JsonProperty("MRData") MRData mrData) {
}