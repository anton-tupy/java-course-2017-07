package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by WizZo on 20.07.2017.
 */
public class CalculatorContext {

    private Map<String, Float> values = new HashMap<>();

    public void defineValue(String name, float value){
        values.put(name,  value);
    }
    public float getValue(String name){
        return values.get(name);

    }
    public boolean isValue(String name){
        return values.get(name) != null;
    }

}
