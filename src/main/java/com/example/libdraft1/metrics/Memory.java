package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ResourceUnit;
import com.example.libdraft1.compute.AvailableResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

@Lazy
@Component
class Memory implements ResourceCalculation {

    private final Logger logger = LoggerFactory.getLogger(Memory.class);
    MemoryUsage MemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
    long availableMemory = (MemoryUsage.getInit() - MemoryUsage.getUsed()) / (1024 * 1024); // to convert bytes to MB

    @Override
    public MetricStatus calculateResources(AvailableResource availableResource) {
        if (availableResource == null || availableResource.value == null || availableResource.value < 0) {
            return new MetricStatus(false, availableResource);
        }
        return new MetricStatus(availableMemory >= availableResource.value, new AvailableResource((int) availableMemory, availableResource.unit));

    }

    @Override
    public AvailableResource getAvailableResource() {
        return new AvailableResource((int) availableMemory, ResourceUnit.MB);
    }
}

