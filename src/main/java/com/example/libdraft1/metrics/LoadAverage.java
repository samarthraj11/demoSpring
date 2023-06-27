package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.AvailableResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;

@Lazy
@Component
class LoadAverage implements ResourceCalculation {

    private final Logger logger = LoggerFactory.getLogger(LoadAverage.class);
    double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();

    @Override
    public MetricStatus calculateResources(AvailableResource availableResource) {
        if (availableResource == null || availableResource.value == null || availableResource.value < 0) {
            return new MetricStatus(false, availableResource);
        }
        return new MetricStatus(currentLoadAvg >= availableResource.value, new AvailableResource((int) currentLoadAvg, availableResource.unit));
    }

    @Override
    public AvailableResource getAvailableResource() {
        return new AvailableResource((int) currentLoadAvg);
    }
}


