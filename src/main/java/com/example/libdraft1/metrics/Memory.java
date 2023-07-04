package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.*;
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

    @Override
    public MetricStatus calculateResources(Resource resource) throws ComputationException {
        try {

            if (resource == null || resource.value == null || resource.value < 0) {
                return new MetricStatus(false, resource);
            }

            MemoryUsage memoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
            long availableMemory = (memoryUsage.getInit() - memoryUsage.getUsed()) / (1024 * 1024); // to convert bytes to MB
            return new MetricStatus(availableMemory >= resource.value, new Resource((int) availableMemory, resource.unit));

        } catch (Exception e) {
            e.printStackTrace();
            throw new ComputationException("Unable to compute heap memory");
        }

    }

    @Override
    public Resource getAvailableResource() throws ComputationException {
        try {

            MemoryUsage memoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
            long availableMemory = (memoryUsage.getInit() - memoryUsage.getUsed()) / (1024 * 1024); // to convert bytes to MB
            return new Resource((int) availableMemory, ResourceUnit.MB);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ComputationException("Unable to compute heap memory");
        }
    }
}

