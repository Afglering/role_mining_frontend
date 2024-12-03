package com.example.role_mining_frontend.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClusteringResponse {
    @JsonProperty("run_id")
    private String runId;

    private String message;

}
