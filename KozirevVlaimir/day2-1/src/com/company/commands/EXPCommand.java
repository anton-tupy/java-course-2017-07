package com.company.commands;

import com.company.CalculatorContext;
import com.company.Comand;
import com.company.anations.In;

import java.util.List;

/**
 * Created by user on 27.07.2017.
 */
public class EXPCommand implements Comand {
    @In
    private CalculatorContext context;
    @Override
    public void execule(List<String> arguments) {
        float value1 = context.pop();
        float result =(float) Math.exp(value1);
        context.push(result);

    }
}
