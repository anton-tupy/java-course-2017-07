package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by Natalya on 20.07.2017.
 */
public class PushCommand implements Command{

    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        if(arguments.isEmpty()){
            throw new RuntimeException("push command: No argument");
        }
        String arg=arguments.get(0);
        char charName= arg.charAt(0);
        if(Character.isLetter(charName)){
            String name=Character.toString(charName);
            float valueName=context.getValue(name);
            context.push(valueName);
        }else{
            float value= Float.parseFloat(arg);//принимает строку и возвращает число
            context.push(value);
        }

       // float valueName=context.getValue(name);
        //context.push(valueName);
        //float value= Float.parseFloat(arg);//принимает строку и возвращает число
        //context.push(value);
    }

}
