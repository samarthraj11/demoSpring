package com.example.libdraft1.compute;

public class ResourceStatus {
    Boolean status;
    String process;
    Resource resource;

    public ResourceStatus(Boolean status, String process, Resource resource) {
        this.status = status;
        this.process = process;
        this.resource = resource;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Resource getAvailableResource() {
        return resource;
    }

    public void setAvailableResource(Resource resource) {
        this.resource = resource;
    }
}
