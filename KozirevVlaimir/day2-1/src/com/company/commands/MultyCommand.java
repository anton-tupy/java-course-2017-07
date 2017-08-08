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
public class MultyCommand implements Comand {
    @In(type = InType.STACK)
    private CalculatorStack stack;
    @Override
    public void execule(List<String> arguments) {
        float value1 = stack.pop();
        float value2 = stack.pop();
        float result = value1 * value2;
        stack.push(result);
    }
}
