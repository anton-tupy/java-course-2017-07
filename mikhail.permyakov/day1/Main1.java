package com.jcourse.permyakov;

public class Main1 {

    public static void main(String[] args) {
	// write your code here

        Greeter greeter = new Greeter("Гуляй, ");

        Greeter greeter1 = new Greeter();
        greeter.greet();
        greeter.greet("имярек");

        greeter1.greet("\n");
        greeter1.greet("\n 123 ");
    }
}
