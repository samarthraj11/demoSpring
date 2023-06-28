package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.MetricStatus;
import com.example.libdraft1.compute.Resource;
import com.example.libdraft1.compute.ResourceUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LoadAverageTest {

    LoadAverage loadAverage;

    @BeforeEach
    void setUp() {
        loadAverage = new LoadAverage();
    }

//    @Test
//    void valueItem_isNull_returnFalse() {
//        assertEquals(loadAverage.calculateResources(null), false);
//    }

//    @Test
//    void ValueItem_Value_IsNull_ReturnFalse() {
//        assertEquals(loadAverage.calculateResources(new AvailableResource(null, ResourceUnit.MB)), false);
//    }
//
//    @Test
//    void ValueItemValue_IsNegative_Return_False() {
//        assertEquals(loadAverage.calculateResources((new AvailableResource(-1, ResourceUnit.MB))), false);
//    }

    @Test
    void availableResource_isNull_returnFalse() {
        assertEquals(loadAverage.calculateResources(null).toString(), new MetricStatus(false, null).toString());
        double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        assertEquals(currentLoadAvg,-1);

    }

}