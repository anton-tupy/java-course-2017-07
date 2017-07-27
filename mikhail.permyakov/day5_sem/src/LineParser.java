import java.util.ArrayList;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class LineParser {

    public ParseResult parse(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }

        String[] items = line.split(" ");
        if (items.length == 0) {
            return null;
        }
        String commandName = items[0];
        ArrayList<String> arguments = new ArrayList<>();
        for (int i = 1; i < items.length; i++) {
            arguments.add(items[i]);
        }
        return new ParseResult(commandName, arguments);
    }

}
