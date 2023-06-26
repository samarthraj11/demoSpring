package com.example.libdraft1.compute;

public class ResourceStatus {
    Process process;
    Boolean status;

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ResourceStatus(Process process, Boolean status)
    {
        this.process = process;
        this.status = status;
    }
}
