package com.example.libdraft1.compute;

public class Resource {
    public Integer value;
    public ResourceUnit unit;

    public Resource(Integer value) {
        this.value = value;
    }

    public Resource(Integer value, ResourceUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ResourceUnit getUnit() {
        return unit;
    }

    public void setUnit(ResourceUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "value=" + value +
                ", unit=" + unit.name() +
                '}';
    }
}
