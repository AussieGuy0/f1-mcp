package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the root object of the JSON response from the F1 API.
 * This class contains common fields that are present in all API responses.
 */
public record MRData(
        @JsonProperty("xmlns") String xmlns,
        @JsonProperty("series") String series,
        @JsonProperty("url") String url,
        @JsonProperty("limit") int limit,
        @JsonProperty("offset") int offset,
        @JsonProperty("total") int total,
        @JsonProperty("CircuitTable") CircuitTable circuitTable,
        @JsonProperty("DriverTable") DriverTable driverTable,
        @JsonProperty("StandingsTable") StandingsTable standingsTable,
        @JsonProperty("ConstructorTable") ConstructorTable constructorTable,
        @JsonProperty("ConstructorStandingsTable") ConstructorStandingsTable constructorStandingsTable) {
}
