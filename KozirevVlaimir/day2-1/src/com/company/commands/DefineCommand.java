package com.company.commands;

import com.company.CalculatorContext;
import com.company.Comand;
import com.company.anations.In;
import com.company.anations.InType;

import java.util.List;

/**
 * Created by user on 22.07.2017.
 */
public class DefineCommand implements Comand {
    @In(type = InType.CONTEXT)
    private CalculatorContext context;
    @Override
    public void execule(List<String> arguments) {
        if (arguments.size() < 2){
            throw new RuntimeException("not Difine");
        }
        String name = arguments.get(0);
        String valueStr = arguments.get(1);
        float value = Float.parseFloat(valueStr);
        context.defineValue(name,value);
    }
}
