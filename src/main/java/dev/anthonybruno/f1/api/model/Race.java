package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record Race(
    @JsonProperty("season") String season,
    @JsonProperty("round") String round,
    @JsonProperty("raceName") String raceName,
    @JsonProperty("Results") List<Result> results,
    @JsonProperty("QualifyingResults") List<QualifyingResult> qualifyingResults,
    @JsonProperty("Laps") List<Lap> laps,
    @JsonProperty("Pitstops") List<Pitstop> pitstops,
    @JsonProperty("SprintResults") List<Sprint> sprintResults
) {} 