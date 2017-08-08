package com.company;


import com.company.commands.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommandFactory {

    private Properties properties;
    private ContextInjactor contextInjactor;



    public CommandFactory(ContextInjactor contextInjactor) {
        this.contextInjactor = contextInjactor;
        try {
            InputStream resourseStream = CommandFactory.class.getResourceAsStream("CommandProperty");
            properties = new Properties();
            properties.load(resourseStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Comand createCommand(String commandName) {
        try {
            String className = properties.getProperty(commandName.toUpperCase());
            if (className==null){
                throw new RuntimeException("Uncexpected command: " + commandName);
            }
            Class<?> aClass = Class.forName(className);
            Object commandObj = aClass.newInstance();
            contextInjactor.inject(commandObj);
            return (Comand) commandObj;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }


//       switch (commandName){
//           case "PUSH":
//               return new PushCommand();
//           case "PRINT":
//               return new PrintCommand();
//          case "POP":
//              return new PopCommand();
//          case "ADD":
//              return new AddCommand();
//          case "DEFINE":
//               return  new DefineCommand();
//           case "MULTY":
//               return new MultyCommand();
//           case "SQR":
//                return new SqrCommand();
//            case "SUBSTRACT":
//               return  new SubstractCommand();
//           case "DIVIN":
//               return new DivinCommand();
//           default:
//                   throw new RuntimeException("Нет команды: " + commandName);
//
//        }
    }
}
