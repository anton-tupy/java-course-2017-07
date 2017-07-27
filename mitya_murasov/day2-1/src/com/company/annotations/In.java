package com.company.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mitro on 27.07.17.
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface In
{

}
