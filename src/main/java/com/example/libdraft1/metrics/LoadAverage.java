package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ValueItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;


@Component
class LoadAverage implements ResourceCalculation {

    Logger logger = LoggerFactory.getLogger(LoadAverage.class);
    @Override
    public Boolean calculateResources(ValueItem valueItem) {
        try {
            double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
            return currentLoadAvg >= valueItem.value;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unable to compute the Load Average");
        }
        return false;

    }
}

