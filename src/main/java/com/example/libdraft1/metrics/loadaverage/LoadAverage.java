package com.example.libdraft1.metrics.loadaverage;

import com.example.libdraft1.calculator.ResourceCalculation;
import com.example.libdraft1.calculator.ValueItem;
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

