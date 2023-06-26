package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ValueItem;
import jakarta.annotation.Nonnull;
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
    public Boolean calculateResources(ValueItem valueItem) {
        if (valueItem == null || valueItem.value == null || valueItem.value < 0) return  false;
        double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        return currentLoadAvg >= valueItem.value;
    }
}


