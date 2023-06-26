package com.example.libdraft1.metrics;


import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ValueItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Lazy
@Component
class Processors implements ResourceCalculation {

    private final Logger logger = LoggerFactory.getLogger(Processors.class);

    @Override
    public MetricStatus calculateResources(ValueItem valueItem) {
        ValueItem dummy = new ValueItem(1);
        if (valueItem == null || valueItem.value == null || valueItem.value < 0) return new MetricStatus(false, dummy);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return new MetricStatus(availableProcessors >= valueItem.value,dummy);

    }
}

