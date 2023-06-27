package com.example.libdraft1.compute;

public class ResourceStatus {
    Boolean status;
    String process;
    AvailableResource availableResource;

    public ResourceStatus(Boolean status, String process, AvailableResource availableResource) {
        this.status = status;
        this.process = process;
        this.availableResource = availableResource;
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

    public AvailableResource getAvailableResource() {
        return availableResource;
    }

    public void setAvailableResource(AvailableResource availableResource) {
        this.availableResource = availableResource;
    }
}
