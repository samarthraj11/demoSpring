package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ComputationException;

public class MemoryException extends ComputationException {
    public MemoryException(String message)
    {
        super(message);
    }
}
