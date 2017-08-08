package com.company.commands;

import com.company.CalculatorStack;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;

public class SqrtCommand implements Command {
    @In(type = InType.STACK)
    private CalculatorStack stack;

    @Override
    public void execute(List<String> arguments) {
//        if (context.isEmpty()) {
//            System.out.println("Стек пустой");
//        } else {
//            context.push((float) Math.sqrt(context.pop()));
//        }
        float value = stack.pop();
        float result = (float) Math.sqrt(value);
        stack.push(result);
    }
}
