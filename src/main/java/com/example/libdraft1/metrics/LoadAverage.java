package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.Resource;
import com.example.libdraft1.compute.ResourceCalculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;

@Lazy
@Component
class LoadAverage implements ResourceCalculation {

    private final Logger logger = LoggerFactory.getLogger(LoadAverage.class);

    @Override
    public MetricStatus calculateResources(Resource resource) {
        if (resource == null || resource.value == null || resource.value < 0) {
            return new MetricStatus(false, resource);
        }
        double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        return new MetricStatus(currentLoadAvg >= resource.value, new Resource((int) currentLoadAvg, resource.unit));
    }


    @Override
    public Resource getAvailableResource() {
        double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        return new Resource((int) currentLoadAvg);
    }
}


