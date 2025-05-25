package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Sprint(
    @JsonProperty("season") String season,
    @JsonProperty("round") String round,
    @JsonProperty("sprintName") String sprintName
) {} 