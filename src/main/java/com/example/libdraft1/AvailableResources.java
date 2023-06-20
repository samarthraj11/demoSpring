package com.example.libdraft1;

import com.example.libdraft1.calculator.Process;
import com.example.libdraft1.calculator.ValueItem;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AvailableResources {
    Boolean isResourcesAvailable(Map<Process, ValueItem> requestedResources);
}
