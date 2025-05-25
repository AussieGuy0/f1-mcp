package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Result(
    @JsonProperty("number") String number,
    @JsonProperty("position") String position,
    @JsonProperty("positionText") String positionText,
    @JsonProperty("points") String points,
    @JsonProperty("Driver") Driver driver,
    @JsonProperty("Constructor") Constructor constructor,
    @JsonProperty("grid") String grid,
    @JsonProperty("laps") String laps,
    @JsonProperty("status") String status,
    @JsonProperty("FastestLap") FastestLap fastestLap
) {} 