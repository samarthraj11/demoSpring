package com.example.libdraft1.compute;

import com.example.libdraft1.user.ResourceTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
class ComputeResources implements ResourceTasks {
    private final Logger logger = LoggerFactory.getLogger(ComputeResources.class);
    @Autowired
    public Map<String, ResourceCalculation> serviceMapper;

    @Override
    public ResourceDetails isResourcesAvailable(Map<Process, Resource> requestedResources) throws ComputationException {

        List<ResourceStatus> resourceStatusList = new ArrayList<>();

        Boolean isEnoughResourcesAvailable = true;

        try {

            logger.info("Started the process to check for the availability of resources");

            for (Map.Entry<Process, Resource> entry : requestedResources.entrySet()) {
                MetricStatus metricStatus = serviceMapper.get(entry.getKey().getValue()).calculateResources(entry.getValue());
                isEnoughResourcesAvailable &= metricStatus.available;
                resourceStatusList.add(new ResourceStatus(metricStatus.available, entry.getKey().getValue(), metricStatus.resource));
            }
            logger.info(": Successfully computed the availability of resources");
            return new ResourceDetails(isEnoughResourcesAvailable, resourceStatusList);

        } catch (Exception e) {
            logger.error("Unable to compute the resources, possibly due to service mapper begin null.");
            logger.info(e.getLocalizedMessage());
            throw new ComputationException("Unable to compute resources" + e.getLocalizedMessage());
        }
    }

    @Override
    public List<Process> getAllProcess() {
        return Arrays.asList(Process.values());
    }

    @Override
    public List<AvailableMetric> getAllResources() throws ComputationException {
        try {

            List<AvailableMetric> availableMetricList = new ArrayList<>();
            for (Map.Entry<String, ResourceCalculation> entry : serviceMapper.entrySet()) {
                AvailableMetric availableMetric = new AvailableMetric(entry.getKey(), entry.getValue().getAvailableResource());
                availableMetricList.add(availableMetric);
            }
            return availableMetricList;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ComputationException("Unable to compute available resources" + e.getLocalizedMessage());
        }
    }
}
