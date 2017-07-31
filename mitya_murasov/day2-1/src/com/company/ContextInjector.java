package com.company;

import com.company.annotations.In;
import com.company.annotations.InType;

import java.lang.reflect.Field;

/**
 * Created by mitro on 27.07.17.
 */
public class ContextInjector
{
    private CalculatorContext context;
    private CalculatorStack stack;

    public ContextInjector(CalculatorContext context, CalculatorStack stack)
    {
        this.context = context;
        this.stack = stack;
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
            InType type = inAnnotation.type();
            field.setAccessible(true);
            try
            {
                switch (type)
                {
                    case CONTEXT:
                        field.set(obj,context);
                        break;
                    case STACK:
                        field.set(obj,stack);
                        break;
                }
                //field.set(obj, context);
            }
            catch (IllegalAccessException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
