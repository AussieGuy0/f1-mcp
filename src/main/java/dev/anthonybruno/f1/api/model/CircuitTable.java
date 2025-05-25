package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a table of circuits in the F1 API response.
 */
public record CircuitTable(
        @JsonProperty("Circuits") List<Circuit> circuits,
        @JsonProperty("position") String position) {
}
