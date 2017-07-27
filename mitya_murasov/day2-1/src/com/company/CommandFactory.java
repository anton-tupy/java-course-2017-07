package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mitro on 20.07.17.
 */
public class CommandFactory
{

    private Properties properties;
    private ContextInjector contextInjector;

    public CommandFactory(ContextInjector contextInjector)
    {
        this.contextInjector = contextInjector;
        try
        {
            InputStream resourceStream = CommandFactory.class.getResourceAsStream("command.properties");
            properties = new Properties();
            properties.load(resourceStream);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }


    public Command createCommand(String commandName)
    {
          try
          {
              String className = properties.getProperty(commandName.toUpperCase());
              if (className == null)
              {
                  throw new RuntimeException("Unexpected command: " + commandName.toUpperCase());
              }
              Class<?> aClass = Class.forName(className);
              Object commandObj = aClass.newInstance();
              contextInjector.injector(commandObj);
              return (Command) commandObj;
          }
          catch (ClassNotFoundException | IllegalAccessException | InstantiationException e)
          {
              throw new RuntimeException(e);
          }
//        switch (commandName.toUpperCase())
//        {
//            case "PUSH":
//                return new PushCommand();
//            case "POP":
//                return new PopCommand();
//            case "PRINT":
//                return new PrintCommand();
//            case "+":
//            case "PLUS":
//                return new AddCommand();
//            case "-":
//            case "MINUS":
//                return new SubtractCommand();
//            case "*":
//            case "MULTIPLY":
//                return new MultiplyCommand();
//            case "/":
//            case "DIVIDE"
//                return new DivideCommand();
//            case "SQRT":
//                return new SqrtCommand();
//            case "DEFINE":
//                return new DefineCommand();
//            default:
//                throw new RuntimeException("Unexpected command: " + commandName);
//        }
    }
}
