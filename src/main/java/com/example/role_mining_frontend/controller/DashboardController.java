package com.example.role_mining_frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String showDashboard(Model model) {
        // Add any required attributes to the model (e.g., dummy data for now)
        model.addAttribute("title", "Role Mining Dashboard");
        model.addAttribute("message", "Welcome to the Role Mining Frontend!");

        // Return the name of the Thymeleaf template (e.g., dashboard.html)
        return "dashboard";
    }
}
