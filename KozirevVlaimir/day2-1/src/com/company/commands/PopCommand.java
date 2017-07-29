package com.company.commands;

import com.company.CalculatorContext;
import com.company.CalculatorStack;
import com.company.Comand;
import com.company.anations.In;
import com.company.anations.InType;

import java.util.List;

/**
 * Created by user on 22.07.2017.
 */
public class PopCommand implements Comand {
    @In(type = InType.CONTEXT)
    private CalculatorContext context;
    @In(type = InType.STACK)
    private CalculatorStack stack;
    @Override
    public void execule(List<String> arguments) {
        float value = stack.pop();
        if (arguments.isEmpty()){
            String name = arguments.get(0);
            context.defineValue(name,value);
        }
    }

}
