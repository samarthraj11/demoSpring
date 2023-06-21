package com.example.libdraft1.metrics;


import com.example.libdraft1.compute.ValueItem;
import com.example.libdraft1.compute.ResourceCalculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Processors implements ResourceCalculation {

    Logger logger = LoggerFactory.getLogger(Processors.class);
    @Override
    public Boolean calculateResources(ValueItem valueItem) {
        try {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            return availableProcessors >= valueItem.value;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unable to compute the Processors");
        }
        return false;
    }
}

