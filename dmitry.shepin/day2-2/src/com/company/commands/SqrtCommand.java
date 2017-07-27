package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;

import java.util.List;

public class SqrtCommand implements Command {
    @In
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
//        if (context.isEmpty()) {
//            System.out.println("Стек пустой");
//        } else {
//            context.push((float) Math.sqrt(context.pop()));
//        }
        float value = context.pop();
        float result = (float) Math.sqrt(value);
        context.push(result);
    }
}
