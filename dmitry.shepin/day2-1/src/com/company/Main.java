package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Calculator calculator = new Calculator();
        calculator.run(args.length > 0 ? args[0] : null); //dfsgsbgf
    }
}
