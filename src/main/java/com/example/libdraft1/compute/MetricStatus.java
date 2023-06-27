package com.example.libdraft1.compute;

public class MetricStatus {
    Boolean available;
    AvailableResource availableResource;

    public MetricStatus(Boolean available, AvailableResource availableResource) {
        this.available = available;
        this.availableResource = availableResource;
    }
}
