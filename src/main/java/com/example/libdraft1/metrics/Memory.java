package com.example.libdraft1.metrics;

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

    private Logger logger = LoggerFactory.getLogger(Memory.class);

    @Override
    public Boolean calculateResources(ValueItem valueItem) {
        try {
            MemoryUsage MemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
            long availableMemory = MemoryUsage.getInit() - MemoryUsage.getUsed();
            return (availableMemory / (1024 * 1024)) >= valueItem.value;

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unable to compute the Memory");
        }
        return false;
    }
}

