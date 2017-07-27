package com.company.commands;


import com.company.CalculatorContext;
import com.company.Comand;
import com.company.anations.In;

import java.util.List;

public class PrintCommand implements Comand{
    @In
    private CalculatorContext context;
    @Override
    public void execule(List<String> arguments) {
        float value = context.peek();
        System.out.println(value);
    }
}
