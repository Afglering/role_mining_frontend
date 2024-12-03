package com.example.role_mining_frontend.service;

import com.example.role_mining_frontend.model.request.ClusteringRequest;
import com.example.role_mining_frontend.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ClusteringService {

    @Autowired
    private RestTemplate restTemplate;

    private final String baseApiUrl = "http://localhost:8000/api/clustering";

    public List<String> getAvailableAlgorithms() {
        String apiUrl = baseApiUrl + "/algorithms";
        AlgorithmListResponse response = restTemplate.getForObject(apiUrl, AlgorithmListResponse.class);
        assert response != null;
        return response.getAlgorithms();
    }

    public AlgorithmParametersResponse getAlgorithmParameters() {
        String apiUrl = baseApiUrl + "/parameters";
        return restTemplate.getForObject(apiUrl, AlgorithmParametersResponse.class);
    }

    public ClusteringResponse runClustering(ClusteringRequest request) {
        String apiUrl = baseApiUrl + "/run";
        return restTemplate.postForObject(apiUrl, request, ClusteringResponse.class);
    }

    public ClusteringResultResponse getClusteringResult(String runId) {
        String apiUrl = baseApiUrl + "/results/" + runId;
        return restTemplate.getForObject(apiUrl, ClusteringResultResponse.class);
    }
}
