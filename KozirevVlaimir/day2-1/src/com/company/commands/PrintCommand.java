package com.company.commands;


import com.company.CalculatorContext;
import com.company.CalculatorStack;
import com.company.Comand;
import com.company.anations.In;
import com.company.anations.InType;

import java.util.List;

public class PrintCommand implements Comand{
    @In(type = InType.STACK)
    private CalculatorStack stack;
    @Override
    public void execule(List<String> arguments) {
        float value = stack.peek();
        System.out.println(value);
    }
}
