package com.commands;


import com.CalculatorStack;
import com.Command;
import com.annotations.In;
import com.annotations.InType;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class PrintCommand implements Command {
    @In (type = InType.STACK)

    private CalculatorStack stack;

    @Override
    public void execute(List<String> arguments) {
        float value = stack.peek();
        System.out.println(value);
    }
}
