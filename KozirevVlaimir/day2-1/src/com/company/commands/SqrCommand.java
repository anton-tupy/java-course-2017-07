package com.company.commands;

import com.company.CalculatorContext;
import com.company.Comand;
import com.company.anations.In;

import java.util.List;

/**
 * Created by user on 22.07.2017.
 */
public class SqrCommand implements Comand {
    @In
    private CalculatorContext context;
    @Override
    public void execule(List<String> arguments) {
        float value = context.pop();
        float result = (float)Math.sqrt(value);
        context.push(result);

    }
}
