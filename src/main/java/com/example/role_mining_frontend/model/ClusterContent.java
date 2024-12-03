package com.example.role_mining_frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class ClusterContent {
    @JsonProperty("cluster_label")
    private String clusterLabel;

    @JsonProperty("user_ids")
    private List<String> userIds;

    @JsonProperty("role_details")
    private Map<String, Integer> roleDetails;

}
