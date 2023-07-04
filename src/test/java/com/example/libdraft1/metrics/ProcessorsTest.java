package com.example.libdraft1.metrics;

import com.example.libdraft1.compute.ComputationException;
import com.example.libdraft1.compute.Resource;
import com.example.libdraft1.compute.ResourceUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import static java.lang.Integer.MAX_VALUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProcessorsTest {

    Processors processors;

    @BeforeEach
    void setUp() {
        processors = new Processors();
    }

    @Test
    void resource_isNull_returnFalse() throws ComputationException {
        assertEquals(processors.calculateResources(null).getAvailable(), false);
    }

    @Test
    void resourceValue_isNull_returnFalse() throws ComputationException {
        assertEquals(processors.calculateResources(new Resource(null, ResourceUnit.MB)).getAvailable(), false);
    }

    @Test
    void resourceValue_isNegative_returnFalse() throws ComputationException {
        assertEquals(processors.calculateResources(new Resource(-1, ResourceUnit.GB)).getAvailable(), false);
    }

    @Test
    void resourceValue_isMaxIntValue_returnFalse() throws ComputationException {
        assertEquals(processors.calculateResources(new Resource(MAX_VALUE, ResourceUnit.GB)).getAvailable(), false);
    }

    @Test
    void resource_ShouldBe_greaterThan_Zero() throws ComputationException {
        assertThat(processors.calculateResources(new Resource(1, ResourceUnit.GB)).getResource().getValue(), greaterThan(-1));
    }

    @Test
    void loadAverage_isNull_returnFalse() {
        PowerMockito.mockStatic(Runtime.class);
        Integer actualValue = Runtime.getRuntime().availableProcessors();
        assertNotEquals(null, actualValue);
    }

    @Test
    void loadAverage_isZero_returnFalse() {
        PowerMockito.mockStatic(Runtime.class);
        Integer actualValue = Runtime.getRuntime().availableProcessors();
        assertNotEquals(0, actualValue);
    }
}