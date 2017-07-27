package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by Natalya on 21.07.2017.
 */
public class MinusCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        float value1 = context.pop();
        float value2 = context.pop();
        float value= value2-value1 ;
        context.push(value);
    }
}
