package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ValueItem;
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
    public MetricStatus calculateResources(ValueItem valueItem) {
        if (valueItem == null || valueItem.value == null || valueItem.value < 0) {
            return new MetricStatus(false, valueItem);
        }
        MemoryUsage MemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        long availableMemory = (MemoryUsage.getInit() - MemoryUsage.getUsed()) / (1024 * 1024); // to convert bytes to MB
        return new MetricStatus(availableMemory >= valueItem.value, new ValueItem((int) availableMemory, valueItem.unit));

    }

    @Override
    public ValueItem getAvailableResource() {
        return null;
    }
}

