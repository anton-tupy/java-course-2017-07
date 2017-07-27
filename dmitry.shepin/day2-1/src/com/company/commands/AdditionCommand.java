package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

public class AdditionCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        if (context.size() >= 2) {
            context.push(context.pop() + context.pop());
        } else if (context.size() == 1) {
            throw new RuntimeException("Необходим еще одни элемент");
        } else {
            System.out.println("Стек пустой");
        }
    }
}
