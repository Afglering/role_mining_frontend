package com.example.role_mining_frontend.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleCreate {
    @JsonProperty("run_id")
    private String runId;

    @JsonProperty("cluster_label")
    private String clusterLabel;

    private String name;
    private String identifier;
    private String description;

    @JsonProperty("created_by")
    private String createdBy;

    // Add 'autoAssignUsers' field
    private Boolean autoAssignUsers;
}
