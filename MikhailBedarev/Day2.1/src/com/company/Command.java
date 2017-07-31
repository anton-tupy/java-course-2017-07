package com.company;

import java.util.List;

/**
 * Created by WizZo on 20.07.2017.
 */
public interface Command {
    void execute(List<String> arguments);
}

