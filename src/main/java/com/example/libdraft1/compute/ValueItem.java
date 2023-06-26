package com.example.libdraft1.compute;

public class ValueItem {
    public Integer value;
    public ResourceUnit unit;

    public ValueItem(Integer value, ResourceUnit unit) {
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

    public ValueItem(Integer value) {
        this.value = value;
    }
}
