package com.example.libdraft1.compute;

public class AvailableMetric {
    String process;
    AvailableResource availableResource;

    public AvailableMetric(String process, AvailableResource availableResource) {
        this.process = process;
        this.availableResource = availableResource;
    }

    public String getProcess() {
        return process;
    }

    public AvailableResource getAvailableResource() {
        return availableResource;
    }

}
