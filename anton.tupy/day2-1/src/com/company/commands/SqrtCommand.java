package com.company.commands;

import com.company.CalculatorStack;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class SqrtCommand implements Command {

    @In(type = InType.STACK)
    private CalculatorStack stack;

    @Override
    public void execute(List<String> arguments) {
        float value = stack.pop();
        float result = (float)Math.sqrt(value);
        stack.push(result);
    }
}
