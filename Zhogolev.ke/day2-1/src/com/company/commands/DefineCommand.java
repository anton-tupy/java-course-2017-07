package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.io.IOException;
import java.util.List;

/**
 * Created by konsz on 22.07.2017.
 */
public class DefineCommand implements Command {

    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
       try {
           context.defineValue(arguments.get(0), Float.parseFloat(arguments.get(1)));
       }
       catch (Exception e){
           System.out.println("DefineClass exception " + e.toString());
       }
    }
}
