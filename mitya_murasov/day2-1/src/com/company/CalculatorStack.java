package com.company;

import java.util.Stack;

/**
 * Created by mitro on 29.07.17.
 */
public class CalculatorStack
{
    private Stack<Float> stack = new java.util.Stack<>();

    public void push(float value)
    {
        stack.push(value);
    }

    public float pop()
    {
        return stack.pop();
    }

    public float peek()
    {
        return stack.pop();
    }
}
