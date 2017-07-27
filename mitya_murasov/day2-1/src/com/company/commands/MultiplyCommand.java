package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;

import java.util.List;

/**
 * Created by mitro on 22.07.17.
 */
public class MultiplyCommand implements Command
{
    @In
    private CalculatorContext context;
    @Override
    public void execute(List<String> arguments)
    {
        float value1 = context.pop();
        float value2 = context.pop();
        float result = value1 * value2;
        context.push(result);
    }
}
