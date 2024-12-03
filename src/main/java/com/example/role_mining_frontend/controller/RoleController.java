package com.example.role_mining_frontend.controller;

import com.example.role_mining_frontend.model.request.UserRoleCreate;
import com.example.role_mining_frontend.model.response.UserRoleResponse;
import com.example.role_mining_frontend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createRole(@ModelAttribute UserRoleCreate request) {
        try {
            // Call the service to create a new user role
            UserRoleResponse response = roleService.createUserRole(request);

            // Return success response
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Return error response with message
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", e.getMessage()));
        }
    }
}
