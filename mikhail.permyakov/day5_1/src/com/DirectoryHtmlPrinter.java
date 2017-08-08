package com;

import java.io.PrintStream;
import java.util.List;

class DirectoryHtmlPrinter {
    void print(String dirname, List<DirectoryItem> directoryItems, PrintStream output){
        output.println("<html>");

        output.println("<head>");
        output.format("<title>Листинг директории %s</title>", dirname);
        output.println("<meta charset = 'utf-8'>");
        output.println("</head>");

        output.println("<body>");
        output.println("<table>");

        output.println("<tr>");
        output.println("<th>Название</th>");
        output.println("<th>Время модификации</th>");
        output.println("<th>Размер</th>");
        output.println("</tr>");



        for(DirectoryItem directoryItem : directoryItems){
            output.println("<tr>");

            output.println("<td>");
            output.format("<a href = '%s'>%s</a>", directoryItem.getPath(), directoryItem.getName());
            output.println("</td>");

            output.println("<td>");
            switch (directoryItem.getType()){
                case FILE:
                    output.println(directoryItem.getChangedAt());
                    break;
                case DIRECTORY:
                    break;
            }
            output.println("</td>");

            output.println("<td>");
            switch (directoryItem.getType()){
                case FILE:
                    output.println(directoryItem.getSize());
                    break;
                case DIRECTORY:
                    break;
            }
            output.println("</td>");

            output.println("</tr>");
        }

        output.println("</table>");
        output.println("</body>");

        output.println("</html>");

    }


}
