package com.company.commands;

import com.company.CalculatorContext;
import com.company.CalculatorStack;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class PopCommand implements Command {

    @In(type = InType.CONTEXT)
    private CalculatorContext context;

    @In(type = InType.STACK)
    private CalculatorStack stack;

    @Override
    public void execute(List<String> arguments) {
        float value = stack.pop();
        if (!arguments.isEmpty()) {
            String name = arguments.get(0);
            context.defineValue(name, value);
        }
    }
}
