package commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class AddCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        float value1 = context.pop();
        float value2 = context.pop();
        float result = value1 + value2;
        context.push(result);
    }
}
