package com.example.libdraft1.user;

import com.example.libdraft1.compute.Process;
import com.example.libdraft1.compute.ResourceDetails;
import com.example.libdraft1.compute.ValueItem;

import java.util.List;
import java.util.Map;

public interface AvailableResources {

    /**
     * The user of this interface has precise control for
     * computing the availability of the requested resources.
     *
     * @param requestedResources consists of Process, and ValueItem
     *                           which contains required quantity as Integer
     *                           and ResourceUnit which is an enum for the unit.
     * @return true if the requested resources are available, and false otherwise.
     */

    ResourceDetails isResourcesAvailable(Map<Process, ValueItem> requestedResources);

    /**
     * this function is used to get all the processes that could be
     * examined for computing the availability of required resources.
     *
     * @return List of Process that are available to compute.
     */
    List<Process> getAllProcess();

    //getAllAvailableResources - return processName, valueItem
}
