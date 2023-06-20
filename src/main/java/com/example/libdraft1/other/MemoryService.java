package com.example.libdraft1.other;

import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;

@Service
public class MemoryService implements ResourceService {


    @Override
    @Nonnull
    public Integer getResource() {
        return 1;
    }

    public void getMemory()
    {
        System.out.println("The memory is 8GB");
    }

}
