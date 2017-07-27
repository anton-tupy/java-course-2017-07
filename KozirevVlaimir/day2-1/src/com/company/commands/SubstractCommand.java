package com.company.commands;

import com.company.CalculatorContext;
import com.company.Comand;
import com.company.anations.In;

import java.util.List;


public class SubstractCommand implements Comand {
    @In
    private CalculatorContext context;
    @Override
    public void execule(List<String> arguments) {
        float value1 = context.pop();
        float value2 = context.pop();
        float result = value2 - value1;
        context.push(result);
    }
}
