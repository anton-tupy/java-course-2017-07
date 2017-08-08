package com.company;

import com.company.commands.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by WizZo on 20.07.2017.
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Command createCommand(String commandName) {
        try {
            String className = properties.getProperty(commandName.toUpperCase());
            if (className == null) {
                throw new RuntimeException("Unexpected command: " + commandName);
            }
            Class<?> aClass = Class.forName(className);
            Object commandObj = aClass.newInstance();
            contextInjector.inject(commandObj);
            return (Command) commandObj;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}


