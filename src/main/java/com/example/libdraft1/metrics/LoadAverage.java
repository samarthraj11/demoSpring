package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ValueItem;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;


@Component
public class LoadAverage implements ResourceCalculation {

    @Override
    public Boolean calculateResources(ValueItem valueItem) {
        try {
            double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
            return currentLoadAvg >= valueItem.value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}

