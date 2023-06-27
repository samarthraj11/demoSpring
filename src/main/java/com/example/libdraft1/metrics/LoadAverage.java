package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ValueItem;
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
    public MetricStatus calculateResources(ValueItem valueItem) {
        if (valueItem == null || valueItem.value == null || valueItem.value < 0) {
            return new MetricStatus(false, valueItem);
        }
        double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        return new MetricStatus(currentLoadAvg >= valueItem.value, new ValueItem((int) currentLoadAvg, valueItem.unit));
    }

    @Override
    public ValueItem getAvailableResource() {
        return null;
    }
}


