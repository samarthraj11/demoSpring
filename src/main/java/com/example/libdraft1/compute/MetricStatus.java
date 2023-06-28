package com.example.libdraft1.compute;

public class MetricStatus {
    Boolean available;
    Resource resource;

    public MetricStatus(Boolean available, Resource resource) {
        this.available = available;
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "MetricStatus{" +
                "available=" + available +
                ", resource=" + resource +
                '}';
    }
}
