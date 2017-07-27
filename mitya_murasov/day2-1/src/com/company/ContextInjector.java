package com.company;

import com.company.annotations.In;

import java.lang.reflect.Field;

/**
 * Created by mitro on 27.07.17.
 */
public class ContextInjector
{
    private CalculatorContext context;

    public ContextInjector(CalculatorContext context)
    {
        this.context = context;
    }

    public void injector(Object obj)
    {
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for(Field field: fields)
        {
            In inAnnotation;
            inAnnotation = field.getAnnotation(In.class);
            if (inAnnotation == null)
            {
                continue;
            }
            field.setAccessible(true);
            try
            {
                field.set(obj, context);
            }
            catch (IllegalAccessException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
