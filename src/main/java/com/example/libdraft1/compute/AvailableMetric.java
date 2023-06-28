package com.example.libdraft1.compute;

public class AvailableMetric {
    String process;
    Resource resource;

    public AvailableMetric(String process, Resource resource) {
        this.process = process;
        this.resource = resource;
    }

    public String getProcess() {
        return process;
    }

    public Resource getAvailableResource() {
        return resource;
    }

}
