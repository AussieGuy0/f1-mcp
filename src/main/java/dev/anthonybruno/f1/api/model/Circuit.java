package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Formula 1 circuit.
 */
public record Circuit(@JsonProperty("circuitId") String circuitId,
            @JsonProperty("url") String url,
            @JsonProperty("circuitName") String circuitName,
            @JsonProperty("Location") Location location) {

}
