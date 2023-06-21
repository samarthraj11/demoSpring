package com.example.libdraft1;

import com.example.libdraft1.compute.Process;
import com.example.libdraft1.compute.ValueItem;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AvailableResources {

    /**
     * The user of this interface has precise control for
     * computing the availability of the requested resources.
     *
     * @param requestedResources consists of process and its
     *                           quantity with the unit for the requested process.
     * @return true if the requested resources are available, and false otherwise.
     */
    Boolean isResourcesAvailable(Map<Process, ValueItem> requestedResources);
}
