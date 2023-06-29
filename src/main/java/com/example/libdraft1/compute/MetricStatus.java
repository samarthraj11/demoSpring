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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
