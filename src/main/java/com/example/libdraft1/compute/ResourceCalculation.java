package com.example.libdraft1.compute;


public interface ResourceCalculation {
    MetricStatus calculateResources(ValueItem valueItem);
    ValueItem getAvailableResource();
}
