package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the location of a circuit.
 */
public record Location(
        @JsonProperty("lat") String lat,
        @JsonProperty("long") String lon,
        @JsonProperty("locality") String locality,
        @JsonProperty("country") String country) {
}
