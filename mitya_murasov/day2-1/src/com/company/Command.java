package com.company;

import java.util.List;

/**
 * Created by mitro on 20.07.17.
 */
public interface Command
{
    void execute(List<String> arguments, CalculatorContext context);
}
