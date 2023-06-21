package com.example.libdraft1.other;


import java.util.HashMap;

public class ResourceServiceAccessorMap extends HashMap<String, String> {

    public ResourceServiceAccessorMap() {
        this.put(
                ResourceKey.MEMORY, "memoryService"
                );
        this.put(
                ResourceKey.THREAD, "threadService"
        );
    }
}
