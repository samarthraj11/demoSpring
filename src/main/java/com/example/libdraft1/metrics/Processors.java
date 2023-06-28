package com.example.libdraft1.metrics;


import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.Resource;
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
    public MetricStatus calculateResources(Resource resource) {
        if (resource == null || resource.value == null || resource.value < 0) {
            return new MetricStatus(false, resource);
        }
        return new MetricStatus(availableProcessors >= resource.value, new Resource(availableProcessors, resource.unit));
    }

    @Override
    public Resource getAvailableResource() {
        return new Resource(availableProcessors);
    }
}

