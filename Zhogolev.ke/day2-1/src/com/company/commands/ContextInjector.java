package com.company.commands;

import com.company.CalculatorContext;
import com.company.anotation.In;

import java.lang.reflect.Field;

/**
 * Created by konsz on 27.07.2017.
 */
public class ContextInjector {

    private CalculatorContext context;

    public ContextInjector(CalculatorContext context){
        this.context = context;
    }
    public void inject(Object obj) throws NoSuchFieldException, IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields){
            In inAnatation = field.getAnnotation(In.class);
                field.getAnnotation(In.class);
                if (inAnatation == null){
                    continue;
                }
                field.setAccessible(true);{
                try {
                    field.set(obj, context);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
