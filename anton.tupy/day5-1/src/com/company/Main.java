package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.List;

public class Main {

    public static void main(String[] args)
            throws DirectoryPrinterException, IOException {
        String dirPath = args[0];
        String htmlFile = args[1];

        DirectoryListingReader directoryReader =
                new DirectoryReaderWithParent(
                        dirPath, new DirectorySortingReader(
                                new DirectoryReader(dirPath)));
        List<DirectoryItem> items = directoryReader.read();
        DirectoryHtmlPrinter htmlPrinter = new DirectoryHtmlPrinter();

        try (PrintStream printStream =
                     new PrintStream(new FileOutputStream(htmlFile))) {
            htmlPrinter.print(dirPath, items, printStream);
        }
    }
}
