package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by konsz on 22.07.2017.
 */
public class AddCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        //добавим первые два элемента (сложим)
        float first  = context.pop();
        float second = context.pop();
        context.push(first + second);

    }
}
