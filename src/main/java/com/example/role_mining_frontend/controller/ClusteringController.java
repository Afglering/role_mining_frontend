package com.example.role_mining_frontend.controller;

import com.example.role_mining_frontend.model.request.ClusteringRequest;
import com.example.role_mining_frontend.model.response.ClusteringResponse;
import com.example.role_mining_frontend.model.response.ClusteringResultResponse;
import com.example.role_mining_frontend.service.ClusteringService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/clustering")
public class ClusteringController {

    @Autowired
    private ClusteringService clusteringService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/new")
    public String showClusteringForm(Model model) {
        model.addAttribute("clusteringRequest", new ClusteringRequest());

        // Get available algorithms and parameters from the API
        model.addAttribute("algorithms", clusteringService.getAvailableAlgorithms());
        model.addAttribute("parameters", clusteringService.getAlgorithmParameters());

        return "clustering_form";
    }

    @PostMapping("/run")
    public String runClustering(@Valid @ModelAttribute ClusteringRequest clusteringRequest, Model model) {
        // Call the service to run clustering
        ClusteringResponse response = clusteringService.runClustering(clusteringRequest);

        // Redirect to the results page
        return "redirect:/clustering/results/" + response.getRunId();
    }

    @GetMapping("/results/{runId}")
    public String viewClusteringResult(@PathVariable String runId, Model model) throws JsonProcessingException {
        ClusteringResultResponse result = clusteringService.getClusteringResult(runId);
        model.addAttribute("clusteringResult", result);

        // Serialize clusters to JSON using the configured ObjectMapper
        String clustersJson = objectMapper.writeValueAsString(result.getClusters());
        model.addAttribute("clustersJson", clustersJson);

        return "clustering_result";
    }
}
