package com.example.libdraft1.metrics;


import com.example.libdraft1.compute.GlobalException;
import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.Resource;
import com.example.libdraft1.compute.ResourceCalculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Lazy
@Component
class Processors implements ResourceCalculation {

    private final Logger logger = LoggerFactory.getLogger(Processors.class);

    @Override
    public MetricStatus calculateResources(Resource resource) throws GlobalException {
        try {

            if (resource == null || resource.value == null || resource.value < 0) {
                return new MetricStatus(false, resource);
            }
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            return new MetricStatus(availableProcessors >= resource.value, new Resource(availableProcessors, resource.unit));

        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException("Unabl to compute available processors");
        }
    }

    @Override
    public Resource getAvailableResource() throws GlobalException {
        try {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            return new Resource(availableProcessors);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException("Unable to compute available processors");
        }
    }
}

