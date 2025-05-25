package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record QualifyingResult(
    @JsonProperty("number") String number,
    @JsonProperty("position") String position,
    @JsonProperty("Driver") Driver driver,
    @JsonProperty("Constructor") Constructor constructor,
    @JsonProperty("Q1") String Q1,
    @JsonProperty("Q2") String Q2,
    @JsonProperty("Q3") String Q3
) {} 