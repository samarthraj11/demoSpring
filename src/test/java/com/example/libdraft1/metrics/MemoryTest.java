package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ComputationException;
import com.example.libdraft1.compute.Resource;
import com.example.libdraft1.compute.ResourceUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryNotificationInfo;
import java.lang.management.OperatingSystemMXBean;
//import org.junit.Test;
import static java.lang.Integer.MAX_VALUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

class MemoryTest {

    Memory memory;

    @BeforeEach
    void setup() {
        memory = new Memory();
    }

    @Test
    void resource_isNull_returnFalse() throws ComputationException {
        assertEquals(memory.calculateResources(null).getAvailable(), false);
    }

    @Test
    void resourceValue_isNull_returnFalse() throws ComputationException {
        assertEquals(memory.calculateResources(new Resource(null, ResourceUnit.MB)).getAvailable(), false);
    }

    @Test
    void resourceValue_isNegative_returnFalse() throws ComputationException {
        assertEquals(memory.calculateResources(new Resource(-1, ResourceUnit.GB)).getAvailable(), false);
    }

    @Test
    void resourceValue_isMaxIntValue_returnFalse() throws ComputationException {
        assertEquals(memory.calculateResources(new Resource(MAX_VALUE, ResourceUnit.GB)).getAvailable(), false);
    }

    @Test
    void resource_ShouldBe_greaterThan_Zero() throws ComputationException {
        assertThat(memory.calculateResources(new Resource(1, ResourceUnit.GB)).getResource().getValue(), greaterThan(-1));
    }

    @Test
    void testing()
    {
        OperatingSystemMXBean mockOS = mock(OperatingSystemMXBean.class);
        double exp = 1.24;
        when(mockOS.getSystemLoadAverage()).thenReturn(exp);
        ManagementFactory mockManagementFactory = mock(ManagementFactory.class);
        when(ManagementFactory.getOperatingSystemMXBean()).thenReturn(mockOS);
    }


}