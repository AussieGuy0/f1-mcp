package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Status(
    @JsonProperty("statusId") String statusId,
    @JsonProperty("status") String status
) {} 