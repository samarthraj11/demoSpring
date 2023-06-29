package com.example.libdraft1.user;

import com.example.libdraft1.compute.*;
import com.example.libdraft1.compute.Process;

import java.util.List;
import java.util.Map;

public interface ResourceTasks {

    /**
     * The user of this interface has precise control for
     * computing the availability of the requested resources.
     *
     * @param requestedResources consists of Process, and ValueItem
     *                           which contains required quantity as Integer
     *                           and ResourceUnit which is an enum for the unit.
     * @return complete details for the availability of the requested resources
     * which consists a boolean stating true, if resources are present and false otherwise
     * And a list of AvailableMetrics consisting of process and its value.
     */
    ResourceDetails isResourcesAvailable(Map<Process, Resource> requestedResources) throws GlobalException;


    /**
     * this function is used to get all the processes that could be
     * examined for computing the availability of required resources.
     *
     * @return List of Process that are available to compute.
     */
    List<Process> getAllProcess();


    /**
     * this function is used to get all the available quantity of
     * all the available metrics.
     *
     * @return List of Available metrics which consists of process and
     * its value.
     */
    List<AvailableMetric> getAllResources() throws GlobalException;
}
