package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mitro on 20.07.17.
 */
public class CalculatorContext
{
    private Stack<Float> stack = new Stack<>();
    private Map<String, Float> values = new HashMap<>();

    public void push(float value)
    {
        stack.push(value);
    }

    public void pop()
    {
        stack.pop();
    }

    public float peek()
    {
        return stack.pop();
    }

    public void defineValue(String name ,float value)
    {
        values.put(name,value);
    }

    public float getValue(String name)
    {
        return values.get(name);
    }

}
