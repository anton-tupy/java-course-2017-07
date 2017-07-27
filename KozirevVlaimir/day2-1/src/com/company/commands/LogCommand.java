package com.company.commands;

import com.company.CalculatorContext;
import com.company.Comand;
import com.company.anations.In;

import java.util.List;

/**
 * Created by user on 27.07.2017.
 */
public class LogCommand implements Comand {
    @In
    private CalculatorContext context;
    @Override
    public void execule(List<String> arguments) {
        float value1 = context.pop();
        float result =(float) Math.log(value1);
        context.push(result);
    }
}
