package com.company;

public class Main {

    public static void main(String[] args) {
	Calculator calculator = new Calculator();
	calculator.run(args.length > 0 ? args[0]: null);
    }
}
