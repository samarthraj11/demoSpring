package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ValueItem;
import com.example.libdraft1.compute.ResourceCalculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

@Component
public class Memory implements ResourceCalculation {

    Logger logger = LoggerFactory.getLogger(Memory.class);
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

