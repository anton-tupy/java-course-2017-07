package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by konsz on 22.07.2017.
 */
public class SqrtCommand implements Command{

    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        float value = context.pop();
        if (value > 0) {
            context.push((float) Math.sqrt(value));
        }else{
            throw new RuntimeException("U can't get sqrt from number below zero");
        }
    }
}
