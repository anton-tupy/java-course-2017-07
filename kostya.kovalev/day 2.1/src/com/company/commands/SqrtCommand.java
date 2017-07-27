package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by Natalya on 21.07.2017.
 */
public class SqrtCommand implements Command {

    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
       // if(arguments.isEmpty()){
      //      throw new RuntimeException("sqrt command: No argument");
      //  }
        float value = context.pop();
        value= (float) Math.sqrt(value);
        context.push(value);
    }
}
