package com.example.libdraft1.compute;

import com.example.libdraft1.user.AvailableResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
class ComputeResources implements AvailableResources {
    private final Logger logger = LoggerFactory.getLogger(ComputeResources.class);
    @Autowired
    public Map<String, ResourceCalculation> serviceMapper;

    @Override
    public ResourceDetails isResourcesAvailable(Map<Process, ValueItem> requestedResources) {

        List<ResourceStatus> resourceStatusList = new ArrayList<>();

        Boolean isEnoughResourcesAvailable = true;

        try {
            logger.info("Started the process to check for the availability of resources");

            for (Map.Entry<Process, ValueItem> entry : requestedResources.entrySet()) {
                MetricStatus processStatus = serviceMapper.get(entry.getKey().getValue()).calculateResources(entry.getValue());
                isEnoughResourcesAvailable &= processStatus.available;
                resourceStatusList.add(new ResourceStatus(entry.getKey().getValue(), processStatus.available, processStatus.valueItem));
            }

            logger.info(": Successfully computed the availability of resources");

        } catch (Exception e) {
            e.printStackTrace();
            isEnoughResourcesAvailable = false;
            logger.error("Unable to compute the resources, possibly due to service mapper begin null.");
        }
        return new ResourceDetails(isEnoughResourcesAvailable, resourceStatusList);
    }

    @Override
    public List<Process> getAllProcess() {
        return Arrays.asList(Process.values());
    }

}
