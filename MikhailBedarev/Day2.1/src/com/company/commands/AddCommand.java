package com.company.commands;

import com.company.CalculatorStack;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;

/**
 * Created by WizZo on 22.07.2017.
 */
public class AddCommand implements Command {
    @In(type = InType.STACK)
    private CalculatorStack stack;

    @Override
    public void execute(List<String> arguments) {
        float value1 = stack.pop();
        float value2 = stack.pop();
        float result = value1 + value2;
        stack.push(result);
    }
}
