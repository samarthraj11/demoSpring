package com.example.libdraft1.calculator;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RequestReceiver {

    private final HashMap<Process, ValueItem> requestedResource = new HashMap<>();

    public RequestReceiver() {
        // these are dummy data
        requestedResource.put(Process.MEMORY, new ValueItem(100, ResourceUnit.MB));
        requestedResource.put(Process.LOAD_AVERAGE, new ValueItem(1));
        requestedResource.put(Process.PROCESSORS, new ValueItem(11));
    }

    public Map<Process, ValueItem> getRequestedResources() {
        return requestedResource;
    }

}
