package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Formula 1 driver.
 */
public record Driver(
        @JsonProperty("driverId") String driverId,
        @JsonProperty("permanentNumber") String permanentNumber,
        @JsonProperty("code") String code,
        @JsonProperty("url") String url,
        @JsonProperty("givenName") String givenName,
        @JsonProperty("familyName") String familyName,
        @JsonProperty("dateOfBirth") String dateOfBirth,
        @JsonProperty("nationality") String nationality) {
}