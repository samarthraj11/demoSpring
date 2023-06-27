package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ResourceUnit;
import com.example.libdraft1.compute.AvailableResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessorsTest {

    Processors processors;

    @BeforeEach
    void setUp() {
        processors = new Processors();
    }

    @Test
    void ValueItem_IsNull_ReturnFalse() {
        assertEquals(processors.calculateResources(null), false);
    }

    @Test
    void ValueItem_Value_IsNull_ReturnFalse() {
        assertEquals(processors.calculateResources(new AvailableResource(null, ResourceUnit.MB)), false);
    }

    @Test
    void ValueItemValue_IsNegative_Return_False() {
        assertEquals(processors.calculateResources((new AvailableResource(-1, ResourceUnit.MB))), false);
    }
}