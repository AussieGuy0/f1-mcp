package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the response from the circuits endpoint.
 */
public record CircuitResponse(
        @JsonProperty("MRData") MRData mrData) {
}
