package com.company.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by WizZo on 27.07.2017.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)//время жизни аннотации
public @interface In {
    InType type();
}
