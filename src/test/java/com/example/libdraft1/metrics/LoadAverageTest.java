package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ResourceUnit;
import com.example.libdraft1.compute.AvailableResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadAverageTest {

    LoadAverage loadAverage;

    @BeforeEach
    void setUp() {
        loadAverage = new LoadAverage();
    }

    @Test
    void valueItem_isNull_returnFalse() {
        assertEquals(loadAverage.calculateResources(null), false);
    }

    @Test
    void ValueItem_Value_IsNull_ReturnFalse() {
        assertEquals(loadAverage.calculateResources(new AvailableResource(null, ResourceUnit.MB)), false);
    }

    @Test
    void ValueItemValue_IsNegative_Return_False() {
        assertEquals(loadAverage.calculateResources((new AvailableResource(-1, ResourceUnit.MB))), false);
    }
}