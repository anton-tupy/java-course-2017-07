package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by Natalya on 21.07.2017.
 */
public class PopCommand implements Command{
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        float value = context.pop();
        //System.out.println("POP "+value);

        //String arg=arguments.get(0);
        //float value= Float.parseFloat(arg);//принимает строку и возвращает число
        //context.pop();
    }
}
