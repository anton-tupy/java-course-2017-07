package com.company;

import com.company.commands.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class CommandFactory {
    private Properties properties;
    private ContextInjector contextInjector;

   public CommandFactory(ContextInjector contextInjector) {
       this.contextInjector = contextInjector;
    try {
        InputStream resourceStream = CommandFactory.class.getResourceAsStream("commands.properties");
        properties = new Properties();
        properties.load(resourceStream);
    }catch (IOException e){
        throw new RuntimeException(e);
    }
   }

    public Command createCommand(String commandName) throws IOException {
       String className = properties.getProperty(commandName.toUpperCase());
       try {
           Class aclass = Class.forName(className);
           Object commandObj = aclass.newInstance();
           contextInjector.inject(commandObj);
           return (Command) commandObj;
       }catch (ClassNotFoundException e){
           throw new RuntimeException();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
       } catch (InstantiationException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
       } catch (NoSuchFieldException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
       }
     /* return (Command) new RuntimeException("no such classes"); */
    }
}
