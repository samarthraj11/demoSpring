package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ComputationException;

public class LoadAverageException  extends ComputationException {
    public LoadAverageException(String message)
    {
        super(message);
    }
}
