package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

public class SqrtCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
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
