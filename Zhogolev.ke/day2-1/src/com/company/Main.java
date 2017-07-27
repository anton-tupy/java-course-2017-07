package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        calculator.run(args.length > 0 ? args[0] : null);
    }
}
