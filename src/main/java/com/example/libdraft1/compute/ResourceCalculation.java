package com.example.libdraft1.compute;


public interface ResourceCalculation {
    MetricStatus calculateResources(AvailableResource availableResource);
    AvailableResource getAvailableResource();
}
