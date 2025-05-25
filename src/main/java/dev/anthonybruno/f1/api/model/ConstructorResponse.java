package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the response from the constructors endpoint.
 */
public record ConstructorResponse(
        @JsonProperty("MRData") MRData mrData) {
}