package com.example.libdraft1.compute;

public class ResourceStatus {
    String process;
    Boolean status;

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ResourceStatus(String process, Boolean status)
    {
        this.process = process;
        this.status = status;
    }
}
