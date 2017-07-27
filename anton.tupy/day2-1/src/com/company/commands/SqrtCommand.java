package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class SqrtCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        float value = context.pop();
        float result = (float)Math.sqrt(value);
        context.push(result);
    }
}
