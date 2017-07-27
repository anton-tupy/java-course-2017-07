package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CalculatorContext {
    private Stack<Float> stack = new Stack<>();
    private Map<String, Float> values = new HashMap<>();


    public void push(float value) {
        stack.push(value);
    }

    public float pop() {
        return stack.pop();
    }

    public float peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

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
