package com.company.commands;

import com.company.CalculatorContext;
import com.company.Comand;
import com.company.anations.In;

import java.util.List;

/**
 * Created by user on 22.07.2017.
 */
public class PopCommand implements Comand {
    @In
    private CalculatorContext context;
    @Override
    public void execule(List<String> arguments) {
        float value = context.pop();
        if (arguments.isEmpty()){
            String name = arguments.get(0);
            context.defineValue(name,value);
        }
    }

}
