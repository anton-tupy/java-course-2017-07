package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.anotation.In;

import java.util.List;

/**
 * Created by konsz on 22.07.2017.
 */
public class SumCommand implements Command{
    @In
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        try {
            float first = context.pop();
            float second = context.pop();
            context.push(second - first);
        }catch (Exception e){
            throw new RuntimeException("stack error Sum");
        }
    }
}
