package com.example.libdraft1.compute;


public interface ResourceCalculation {
    MetricStatus calculateResources(Resource resource) throws ComputationException;
    Resource getAvailableResource() throws ComputationException;
}
