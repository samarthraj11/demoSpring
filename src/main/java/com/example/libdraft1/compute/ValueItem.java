package com.example.libdraft1.compute;

public class ValueItem {
    public Integer value;
    public ResourceUnit unit;

    public ValueItem(Integer value, ResourceUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public ValueItem(Integer value) {
        this.value = value;
    }
}
