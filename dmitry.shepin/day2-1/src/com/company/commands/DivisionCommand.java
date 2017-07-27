package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

public class DivisionCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        if (context.size() >= 2) {
            float a = context.pop();
            float b = context.pop();
            if (b == 0) {
                System.out.println("Деление на ноль!!!");
            } else {
                context.push(a / b);
            }
        } else if (context.size() == 1) {
            System.out.println("Необходим еще один аргумент");
        } else {
            System.out.println("Стек пустой");
        }
    }
}





