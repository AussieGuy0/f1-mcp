package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Season(
    @JsonProperty("season") String season,
    @JsonProperty("url") String url
) {} 