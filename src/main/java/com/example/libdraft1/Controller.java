package com.example.libdraft1;

import com.example.libdraft1.calculator.ComputeResources;
import com.example.libdraft1.calculator.Process;
import com.example.libdraft1.calculator.ResourceUnit;
import com.example.libdraft1.calculator.ValueItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class Controller {

    @Autowired
    AvailableResources availableResources;

    @GetMapping("/q")
    public void getClassFromBeans() {

        HashMap<Process, ValueItem> resourceMap = new HashMap<>();
        resourceMap.put(Process.MEMORY, new ValueItem(100, ResourceUnit.MB));
        resourceMap.put(Process.LOAD_AVERAGE, new ValueItem(1));
        resourceMap.put(Process.PROCESSORS, new ValueItem(11));
        System.out.println("Are Resources available: " + availableResources.isResourcesAvailable(resourceMap));
    }


}
