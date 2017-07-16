package com.company;

import com.company.pkg.*;

public class Main {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.greet();

        String hello = "Привет";
        Greeter greeter2 = new Greeter(hello);
        String name = "Вася";
        greeter2.greet(name);

        Greeter greeter3 = new com.company.Greeter(hello);

        com.company.pkg.OneThing thing = new com.company.pkg.OneThing();
    }
}
