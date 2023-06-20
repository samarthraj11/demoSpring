package com.example.libdraft1.calculator;

public enum Process {
    LOAD_AVERAGE("loadAverage"), MEMORY("memory"), PROCESSORS("processors");

    private final String value;

    Process(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
