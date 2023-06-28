package com.example.libdraft1.metrics.provider;

import java.lang.management.MemoryUsage;

public interface IMemoryProvider {
    MemoryUsage getCurrentMemoryUsage();
}
