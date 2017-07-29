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
public class SqrCommand implements Comand {
    @In(type = InType.STACK)
    private CalculatorStack stack;
    @Override
    public void execule(List<String> arguments) {
        float value = stack.pop();
        float result = (float)Math.sqrt(value);
        stack.push(result);

    }
}
