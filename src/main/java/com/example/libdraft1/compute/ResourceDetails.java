package com.example.libdraft1.compute;

import java.util.List;

public class ResourceDetails {
    Boolean isResourceAvailable;
    List<ResourceStatus> resourceStatusList;

    public ResourceDetails(Boolean isResourceAvailable, List<ResourceStatus> resourceStatusList)
    {
        this.isResourceAvailable = isResourceAvailable;
        this.resourceStatusList = resourceStatusList;
    }

    public Boolean getResourceAvailable() {
        return isResourceAvailable;
    }


    public List<ResourceStatus> getResourceStatusList() {
        return resourceStatusList;
    }
}
