package com.example.libdraft1.compute;

import com.example.libdraft1.user.AvailableResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ComputeResources implements AvailableResources {

    @Autowired
    public Map<String, ResourceCalculation> serviceMapper;

    @Override
    public Boolean isResourcesAvailable(Map<Process, ValueItem> requestedResources) {
        Boolean isEnoughResourcesAvailable = true;
        for (Map.Entry<Process, ValueItem> entry : requestedResources.entrySet()) {
            isEnoughResourcesAvailable &= serviceMapper.get(entry.getKey().getValue()).calculateResources(entry.getValue());
        }
        return isEnoughResourcesAvailable;
    }

}
