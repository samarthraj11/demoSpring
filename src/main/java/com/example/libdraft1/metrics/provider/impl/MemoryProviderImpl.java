package com.example.libdraft1.metrics.provider.impl;

import com.example.libdraft1.metrics.provider.IMemoryProvider;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

public class MemoryProviderImpl implements IMemoryProvider {
    @Override
    public MemoryUsage getCurrentMemoryUsage() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
    }
}
