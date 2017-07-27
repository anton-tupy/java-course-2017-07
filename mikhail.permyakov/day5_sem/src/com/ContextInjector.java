package com;

import com.annotations.In;

import java.lang.reflect.Field;

/**
 * Created by lab on 27.07.2017.
 */
public class ContextInjector {
    private CalculatorContext context;

    public ContextInjector(CalculatorContext context){
        this.context = context;
    }
    public void inject (Object obj){
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            In inAnnotation = field.getAnnotation(In.class);
            if (inAnnotation == null){
                continue;
            }
            field.setAccessible(true);
            try {
                field.set(obj, context);
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }

    }
}
