package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.Resource;
import com.example.libdraft1.compute.ResourceCalculation;
//import org.junit.Test;
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
    public MetricStatus calculateResources(Resource resource) throws LoadAverageException{
        if (resource == null || resource.value == null || resource.value < 0) {
            return new MetricStatus(false, resource);
        }
        try {
            double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
//            throw new Exception();
            return new MetricStatus(currentLoadAvg >= resource.value, new Resource((int) currentLoadAvg, resource.unit));
        } catch (Exception e)
        {
            throw new LoadAverageException("Unable to compute current load average");
        }
    }


    @Override
    public Resource getAvailableResource() throws LoadAverageException{
        try {

            double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
            return new Resource((int) currentLoadAvg);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new LoadAverageException("Unable to compute load average");
        }
    }
}


