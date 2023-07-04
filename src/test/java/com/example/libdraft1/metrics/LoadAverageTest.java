package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.Resource;
import com.example.libdraft1.compute.ResourceUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import static java.lang.Integer.MAX_VALUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class LoadAverageTest {

    LoadAverage loadAverage;

    @BeforeEach
    void setUp() {
        loadAverage = new LoadAverage();
    }

    @Test
    void resource_isNull_returnFalse() throws LoadAverageException {
        assertEquals(false, loadAverage.calculateResources(null).getAvailable());
    }

    @Test
    void resourceValue_isNull_returnFalse() throws LoadAverageException {
        assertEquals(false, loadAverage.calculateResources(new Resource(null, ResourceUnit.MB)).getAvailable());
    }

    @Test
    void resourceValue_isNegative_returnFalse() throws LoadAverageException {
        assertEquals(false, loadAverage.calculateResources(new Resource(-1, ResourceUnit.GB)).getAvailable());
    }

    @Test
    void resourceValue_isMaxIntValue_returnFalse() throws LoadAverageException {
        assertEquals(false, loadAverage.calculateResources(new Resource(MAX_VALUE, ResourceUnit.GB)).getAvailable());
    }

    @Test
    void resource_ShouldBe_greaterThan_Zero() throws LoadAverageException {
        assertThat(loadAverage.calculateResources(new Resource(1, ResourceUnit.GB)).getResource().getValue(), greaterThan(-1));
    }

    @Test
    void getSystemLoadAvg_givesException_returnFalse() {
        try {
            double currentLoadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
            assertTrue(currentLoadAvg > 0);
        } catch (Exception e) {
            fail("unable to fetch systemLoadAverage");
        }
    }

//    @Test
//    void loadAverage_isNull_returnFalse() {
//        PowerMockito.mockStatic(ManagementFactory.class);
//        double actualValue = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
//        assertNotEquals(null, actualValue);
//    }
//
//    @Test
//    void loadAverage_isNegative_returnFalse() {
//        PowerMockito.mockStatic(ManagementFactory.class);
//        double actualValue = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
//        assertNotEquals(-1, actualValue);
//    }

    @Test
    public void loadAverage_throwsException_returnFalse() {

        OperatingSystemMXBean mockOS = mock(OperatingSystemMXBean.class);
        double exp = 1.23;
        when(ManagementFactory.getOperatingSystemMXBean()).thenReturn(mockOS);
//        double current = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
//        assertEquals(expected, current, 0.1);
    }

//    @Test
//    void test()
//    {
////        assertThrows();
//    }
}
//        assertThrows(loadAverage.calculateResources(null),new ComputationException(null));
//        Exception exception = assertThrows(LoadAverageException.class, () -> {
//            loadAverage.calculateResources(null);
//        });
////        System.out.println(exception.getMessage());
//        assertFalse("unable to compute current load average".contains(exception.getMessage()));
//        PowerMockito.mockStatic(ManagementFactory.class);
//        OperatingSystemMXBean operatingSystemMXBean = mock(OperatingSystemMXBean.class);
//        PowerMockito.when(ManagementFactory.getOperatingSystemMXBean()).thenReturn(operatingSystemMXBean);