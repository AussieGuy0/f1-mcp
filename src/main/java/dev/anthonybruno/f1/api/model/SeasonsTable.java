package dev.anthonybruno.f1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record SeasonsTable(
    @JsonProperty("Seasons") List<Season> seasons
) {} 