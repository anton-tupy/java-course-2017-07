package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

public class MultiplicationCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        if (context.size() >= 2) {
            context.push(context.pop() * context.pop());
        } else if (context.size() == 1) {
            System.out.println("Необходим еще один аргумент");
        } else {
            System.out.println("Стек пустой");
        }
    }
}
