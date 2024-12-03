package com.example.role_mining_frontend.model.response;

import com.example.role_mining_frontend.model.ClusterContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ClusteringResultResponse {
    private List<ClusterContent> clusters;

    @JsonProperty("run_id")
    private String runId;

    private String status;

}
