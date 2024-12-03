package com.example.role_mining_frontend.model.request;

import com.example.role_mining_frontend.model.enums.DBSCANAlgorithm;
import com.example.role_mining_frontend.model.enums.DBSCANMetric;
import com.example.role_mining_frontend.model.enums.HierarchicalLinkage;
import com.example.role_mining_frontend.model.enums.HierarchicalMetric;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClusteringRequest {
    private String algorithm;

    @JsonProperty("random_state")
    private Integer randomState = 42;

    @JsonProperty("n_clusters")
    private Integer numClusters;

    @JsonProperty("min_clusters")
    private Integer minClusters = 3;

    @JsonProperty("max_clusters")
    private Integer maxClusters = 8;

    @JsonProperty("kmeans_n_init")
    private Integer kmeansNInit = 10;

    @JsonProperty("kmeans_max_iter")
    private Integer kmeansMaxIter = 300;

    @JsonProperty("hierarchical_linkage")
    private HierarchicalLinkage hierarchicalLinkage = HierarchicalLinkage.ward;

    @JsonProperty("hierarchical_metric")
    private HierarchicalMetric hierarchicalMetric = HierarchicalMetric.euclidean;

    @JsonProperty("dbscan_eps")
    private Double dbscanEps;

    @JsonProperty("dbscan_min_samples")
    private Integer dbscanMinSamples = 5;

    @JsonProperty("dbscan_metric")
    private DBSCANMetric dbscanMetric = DBSCANMetric.euclidean;

    @JsonProperty("dbscan_algorithm")
    private DBSCANAlgorithm dbscanAlgorithm = DBSCANAlgorithm.auto;
}
