package com.example.libdraft1.metrics.processors;


import com.example.libdraft1.calculator.ValueItem;
import com.example.libdraft1.calculator.ResourceCalculation;
import org.springframework.stereotype.Component;

@Component
public class Processors implements ResourceCalculation {
    @Override
    public Boolean calculateResources(ValueItem valueItem) {
        try {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
//            System.out.println("Processors: " + availableProcessors);
            return availableProcessors >= valueItem.value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

