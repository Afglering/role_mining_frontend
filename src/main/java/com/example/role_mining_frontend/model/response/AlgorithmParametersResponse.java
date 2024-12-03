package com.example.role_mining_frontend.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlgorithmParametersResponse {
    private List<String> hierarchicalLinkageOptions;
    private List<String> hierarchicalMetricOptions;
    private List<String> dbscanMetricOptions;
    private List<String> dbscanAlgorithmOptions;
}