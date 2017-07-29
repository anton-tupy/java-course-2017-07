package com.commands;

import com.CalculatorStack;
import com.Command;
import com.annotations.In;
import com.annotations.InType;

import java.util.List;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class ExpCommand implements Command {
    @In (type = InType.STACK)

    private CalculatorStack stack;

    @Override
    public void execute(List<String> arguments) {
        float value = stack.pop();
        float result = (float)Math.exp(value);
        stack.push(result);
    }
}