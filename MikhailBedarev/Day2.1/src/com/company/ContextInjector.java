package com.company;

import com.company.annotations.In;
import com.company.annotations.InType;

import java.lang.reflect.Field;

/**
 * Created by WizZo on 27.07.2017.
 */
public class ContextInjector {
    private CalculatorContext context;
    private CalculatorStack stack;

    public ContextInjector(CalculatorContext context, CalculatorStack stack) {
        this.context = context;
        this.stack = stack;
    }
    public void inject(Object obj){
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for(Field field : fields){
            In inAnnoutation = field.getAnnotation(In.class);
            if(inAnnoutation == null){
                continue;
            }
            InType type = inAnnoutation.type();
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
                throw new RuntimeException(e);
            }
        }

    }
}
