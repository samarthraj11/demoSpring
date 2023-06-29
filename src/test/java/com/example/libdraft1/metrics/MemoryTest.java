package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.GlobalException;
import com.example.libdraft1.compute.Resource;
import com.example.libdraft1.compute.ResourceUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import java.lang.management.ManagementFactory;

import static java.lang.Integer.MAX_VALUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MemoryTest {

    Memory memory;

    @BeforeEach
    void setup() {
        memory = new Memory();
    }

    @Test
    void resource_isNull_returnFalse() throws GlobalException {
        assertEquals(memory.calculateResources(null).getAvailable(), false);
    }

    @Test
    void resourceValue_isNull_returnFalse() throws GlobalException {
        assertEquals(memory.calculateResources(new Resource(null, ResourceUnit.MB)).getAvailable(), false);
    }

    @Test
    void resourceValue_isNegative_returnFalse() throws GlobalException {
        assertEquals(memory.calculateResources(new Resource(-1, ResourceUnit.GB)).getAvailable(), false);
    }

    @Test
    void resourceValue_isMaxIntValue_returnFalse() throws GlobalException {
        assertEquals(memory.calculateResources(new Resource(MAX_VALUE, ResourceUnit.GB)).getAvailable(), false);
    }

    @Test
    void resource_ShouldBe_greaterThan_Zero() throws GlobalException {
        assertThat(memory.calculateResources(new Resource(1, ResourceUnit.GB)).getResource().getValue(), greaterThan(-1));
    }

    @Test
    void loadAverage_isNegative_returnFalse() {
        PowerMockito.mockStatic(ManagementFactory.class);
        Long actualValue = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getInit();
        assertNotEquals(-1, actualValue);
    }

    @Test
    void loadAverage_isNull_returnFalse() {
        PowerMockito.mockStatic(ManagementFactory.class);
        Long actualValue = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getInit();
        assertNotEquals(null, actualValue);
    }


}