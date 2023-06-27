package com.example.libdraft1.metrics;


import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.AvailableResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Lazy
@Component
class Processors implements ResourceCalculation {

    private final Logger logger = LoggerFactory.getLogger(Processors.class);

    int availableProcessors = Runtime.getRuntime().availableProcessors();

    @Override
    public MetricStatus calculateResources(AvailableResource availableResource) {
        if (availableResource == null || availableResource.value == null || availableResource.value < 0) {
            return new MetricStatus(false, availableResource);
        }
        return new MetricStatus(availableProcessors >= availableResource.value, new AvailableResource(availableProcessors, availableResource.unit));
    }

    @Override
    public AvailableResource getAvailableResource() {
        return new AvailableResource(availableProcessors);
    }
}

