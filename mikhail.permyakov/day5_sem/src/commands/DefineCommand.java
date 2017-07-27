package commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class DefineCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        if (arguments.size() < 2) {
            throw new RuntimeException("DefineCommand: too few arguments");
        }
        String name = arguments.get(0);
        String valueStr = arguments.get(1);
        float value = Float.parseFloat(valueStr);
        context.defineValue(name, value);
    }
}
