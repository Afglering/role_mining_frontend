package com.example.role_mining_frontend.service;

import com.example.role_mining_frontend.model.request.UserRoleCreate;
import com.example.role_mining_frontend.model.response.UserRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RoleService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_BASE_URL = "http://localhost:8000";

    public UserRoleResponse createUserRole(UserRoleCreate request) {
        String url = API_BASE_URL + "/api/clustering/create_user_role";

        Boolean autoAssignUsers = request.getAutoAssignUsers();
        if (autoAssignUsers == null) {
            // Default to false if 'autoAssignUsers' is null
            autoAssignUsers = false;
        }

        // Build the URI with query parameters using fromUriString
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("auto_assign_users", autoAssignUsers);

        // Build the URI
        URI uri = uriBuilder.build().toUri();

        // Send the POST request
        return restTemplate.postForObject(
                uri,
                request,
                UserRoleResponse.class
        );
    }
}
