package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record RaceTable(
    @JsonProperty("Races") List<Race> races
) {} 