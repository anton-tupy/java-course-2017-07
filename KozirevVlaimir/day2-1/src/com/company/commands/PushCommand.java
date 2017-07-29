package com.company.commands;

import com.company.CalculatorContext;
import com.company.CalculatorStack;
import com.company.Comand;
import com.company.anations.In;
import com.company.anations.InType;

import java.util.List;


public class PushCommand implements Comand {
    @In(type = InType.CONTEXT)
    private CalculatorContext context;
    @In(type = InType.STACK)
    private CalculatorStack stack;
    @Override
    public void execule(List<String> arguments) {
        if (arguments.isEmpty()){
            throw new RuntimeException("No arguments");
        }
        String arg = arguments.get(0);
        float value;
        if (context.isValue(arg)){
            value = context.getValue(arg);
        }
        else {
            value = Float.parseFloat(arg);
        }

        stack.push(value);
    }
}
