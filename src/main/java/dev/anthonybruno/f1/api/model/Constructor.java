package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Formula 1 constructor (team).
 */
public record Constructor(
        @JsonProperty("constructorId") String constructorId,
        @JsonProperty("url") String url,
        @JsonProperty("name") String name,
        @JsonProperty("nationality") String nationality) {
}