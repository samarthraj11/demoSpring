package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ResourceUnit;
import com.example.libdraft1.compute.Resource;
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
    MemoryUsage memoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
    long availableMemory = (memoryUsage.getInit() - memoryUsage.getUsed()) / (1024 * 1024); // to convert bytes to MB

    @Override
    public MetricStatus calculateResources(Resource resource) {
        if (resource == null || resource.value == null || resource.value < 0) {
            return new MetricStatus(false, resource);
        }
        return new MetricStatus(availableMemory >= resource.value, new Resource((int) availableMemory, resource.unit));

    }

    @Override
    public Resource getAvailableResource() {
        return new Resource((int) availableMemory, ResourceUnit.MB);
    }
}

