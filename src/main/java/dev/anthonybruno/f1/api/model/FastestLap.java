package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FastestLap(
    @JsonProperty("rank") String rank,
    @JsonProperty("lap") String lap,
    @JsonProperty("time") String time,
    @JsonProperty("averageSpeed") String averageSpeed
) {} 