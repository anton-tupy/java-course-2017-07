package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by Natalya on 20.07.2017.
 */
public class PrintCommand implements Command{

    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        //float value = context.peek();
        float value= context.peek();
        System.out.println(+value);
        //float value1= context.pop();
        //System.out.println("X1= "+value1);
    }
}
