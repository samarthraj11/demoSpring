import com.example.libdraft1.compute.ComputeResources;
import com.example.libdraft1.compute.ResourceCalculation;
import com.example.libdraft1.compute.ResourceDetails;
import com.example.libdraft1.compute.ResourceStatus;
import com.example.libdraft1.user.Process;
import com.example.libdraft1.user.Resource;
import com.example.libdraft1.user.ResourceTasks;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ComputeResourcesTest {

    @Mock
    private Map<String, ResourceCalculation> serviceMapper;

    @InjectMocks
    private ComputeResources computeResources;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIsResourcesAvailable() throws ComputationException {
        // Create some sample data
        Map<Process, Resource> requestedResources = new HashMap<>();
        requestedResources.put(Process.PROCESS1, new Resource(10, "unit1"));
        requestedResources.put(Process.PROCESS2, new Resource(20, "unit2"));

        // Create mock ResourceCalculation objects
        ResourceCalculation resourceCalculation1 = mock(ResourceCalculation.class);
        ResourceCalculation resourceCalculation2 = mock(ResourceCalculation.class);

        // Mock the behavior of the ResourceCalculation objects
        when(resourceCalculation1.calculateResources(any(Resource.class)))
                .thenReturn(new MetricStatus(true, new Resource(10, "unit1")));
        when(resourceCalculation2.calculateResources(any(Resource.class)))
                .thenReturn(new MetricStatus(true, new Resource(20, "unit2")));

        // Set up the serviceMapper mock
        serviceMapper.put(Process.PROCESS1.getValue(), resourceCalculation1);
        serviceMapper.put(Process.PROCESS2.getValue(), resourceCalculation2);

        // Perform the test
        ResourceDetails resourceDetails = computeResources.isResourcesAvailable(requestedResources);

        // Assert the result
        assertTrue(resourceDetails.isEnoughResourcesAvailable());
        assertEquals(2, resourceDetails.getResourceStatusList().size());
        // Assert other properties of the result as needed
    }

    // ... Additional test methods for other scenarios
}
