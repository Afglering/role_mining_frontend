package com.example.role_mining_frontend.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserRoleResponse {
    private String id;
    private String name;
    private String identifier;
    private String description;

    @JsonProperty("created_by")
    private String createdBy;

    private LocalDateTime created;
}
