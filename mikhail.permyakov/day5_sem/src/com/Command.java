package com;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public interface Command {
    void execute(List<String> arguments);
}
