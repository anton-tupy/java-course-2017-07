package com.company;

import java.util.Stack;

/**
 * Created by IT-Academy on 29.07.2017.
 */
public class CalculatorStack {
    private Stack<Float> stack = new Stack<>();

    public void push(float value) {
        stack.push(value);
    }

    public float pop() {
        return stack.pop();
    }

    public float peek() {
        return stack.peek();
    }

}
