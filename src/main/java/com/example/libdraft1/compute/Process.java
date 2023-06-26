package com.example.libdraft1.compute;

public enum Process {
    LOAD_AVERAGE("loadAverage"), MEMORY("memory"), PROCESSOR("processor");

    private final String value;

    Process(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
