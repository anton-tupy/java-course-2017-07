package com.commands;


import com.CalculatorStack;
import com.Command;
import com.annotations.In;
import com.annotations.InType;

import java.util.List;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class DivideCommand implements Command {
    @In (type = InType.STACK)

    private CalculatorStack stack;

    @Override
    public void execute(List<String> arguments) {
        float value1 = stack.pop();
        float value2 = stack.pop();
        float result = value2 / value1;
        stack.push(result);
    }
}
