package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

public class PopCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
//        if (context.isEmpty()) {
//            System.out.println("Стек пустой");
//        } else {
//            context.pop();
//        }
        float value=context.pop();
        String name=arguments.get(0);
        context.defineValue(name,value);
    }
}
