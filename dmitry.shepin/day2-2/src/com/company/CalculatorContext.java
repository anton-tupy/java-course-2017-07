package com.company;

import java.util.HashMap;
import java.util.Map;

public class CalculatorContext {

    private Map<String, Float> values = new HashMap<>();


    public void defineValue(String name, float value) { //name-ключ, value-значение;
        values.put(name, value);
    }

    public float getValue(String name) {
        return values.get(name);
    }

    public boolean isValue(String name) {
        return values.get(name) != null;
    }

}
