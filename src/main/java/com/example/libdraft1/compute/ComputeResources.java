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

    @Autowired
    public Map<String, ResourceCalculation> serviceMapper;
    private Logger logger = LoggerFactory.getLogger(ComputeResources.class);

    @Override
    public Boolean isResourcesAvailable(Map<Process, ValueItem> requestedResources) {
        try {
            logger.info("Started the process to check for the availability of resources");
            Boolean isEnoughResourcesAvailable = true;
            for (Map.Entry<Process, ValueItem> entry : requestedResources.entrySet()) {
                isEnoughResourcesAvailable &= serviceMapper.get(entry.getKey().getValue()).calculateResources(entry.getValue());
            }
            logger.info("Successfully computed the availability of resources");
            return isEnoughResourcesAvailable;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unable to compute the resources, possibly due to service mapper begin null.");
        }
        return false;
    }

    @Override
    public List<Process> getAllProcess() {
        return Arrays.asList(Process.values());
    }

}
