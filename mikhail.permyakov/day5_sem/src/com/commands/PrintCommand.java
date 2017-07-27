package com.commands;


import com.CalculatorContext;
import com.Command;
import com.annotations.In;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class PrintCommand implements Command {
    @In
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        float value = context.peek();
        System.out.println(value);
    }
}
