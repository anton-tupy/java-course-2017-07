package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by Natalya on 21.07.2017.
 */
public class DefineCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        if(arguments.size()<2){
            throw new RuntimeException("DefineCommand: too few arguments");
        }
        String name=arguments.get(0);
        String arg=arguments.get(1);
        float value= Float.parseFloat(arg);//принимает строку и возвращает число
        context.defineValue(name,value);
    }
}
