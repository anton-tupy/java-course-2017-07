package com.company.commands;

import com.company.CalculatorStack;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;

/**
 * Created by WizZo on 20.07.2017.
 */
public class PrintCommand implements Command {
    @In(type = InType.STACK)
    private CalculatorStack stack;
    @Override
    public void execute(List<String> arguments) {
        float value = stack.peek();
        System.out.println(value);
    }
}
