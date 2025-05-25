package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Pitstop(
    @JsonProperty("driverId") String driverId,
    @JsonProperty("lap") String lap,
    @JsonProperty("stop") String stop,
    @JsonProperty("time") String time,
    @JsonProperty("duration") String duration
) {} 