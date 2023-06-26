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

    public void setResourceAvailable(Boolean resourceAvailable) {
        isResourceAvailable = resourceAvailable;
    }

    public List<ResourceStatus> getResourceStatusList() {
        return resourceStatusList;
    }

    public void setResourceStatusList(List<ResourceStatus> resourceStatusList) {
        this.resourceStatusList = resourceStatusList;
    }
}
