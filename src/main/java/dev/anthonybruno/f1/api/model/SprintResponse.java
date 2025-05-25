package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SprintResponse(
    @JsonProperty("MRData") MRData mrData
) {} 