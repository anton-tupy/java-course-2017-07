package com.company;

import com.company.anations.In;
import com.company.anations.InType;

import java.lang.reflect.Field;

public class ContextInjactor {
    private CalculatorContext context;
    private CalculatorStack stack;

    public ContextInjactor(CalculatorContext context,CalculatorStack stack){
        this.context = context;
        this.stack = stack;
    }

    public void inject(Object obj){
        Class<?>aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field: fields){
            In inAnntation = field.getAnnotation(In.class);
            if (inAnntation == null){
                continue;
            }
            InType type = inAnntation.type();
            field.setAccessible(true);
            try {
                switch (type){
                    case CONTEXT:
                        field.set(obj,context);
                        break;
                    case STACK:
                        field.set(obj,stack);
                        break;
                }
            } catch (IllegalAccessException e) {
                throw  new RuntimeException(e);
            }
        }
    }
}
