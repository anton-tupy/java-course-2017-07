package com;

import java.util.List;

public class Main {
    public static void main(String[] args) throws DirectoryPrinterException{
        DirectoryReader directoryReader = new DirectoryReader(args[0]);
        List<DirectoryItem> items = directoryReader.read();
        for(DirectoryItem item : items){
            System.out.println("Directory item: " + item);
        }
    }
}
