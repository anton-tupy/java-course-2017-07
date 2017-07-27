package com.company;

import com.company.anations.In;

import java.lang.reflect.Field;

public class ContextInjactor {
    private CalculatorContext context;

    public ContextInjactor(CalculatorContext context){
        this.context = context;
    }

    public void inject(Object obj){
        Class<?>aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field: fields){
            In inAnntation = field.getAnnotation(In.class);
            if (inAnntation == null){
                continue;
            }
            field.setAccessible(true);
            try {
                field.set(obj,context);
            } catch (IllegalAccessException e) {
                throw  new RuntimeException(e);
            }
        }
    }
}
