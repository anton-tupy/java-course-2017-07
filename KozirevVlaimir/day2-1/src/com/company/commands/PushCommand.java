package com.company.commands;

import com.company.CalculatorContext;
import com.company.Comand;
import com.company.anations.In;

import java.util.List;


public class PushCommand implements Comand {
    @In
    private CalculatorContext context;
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

        context.push(value);
    }
}
