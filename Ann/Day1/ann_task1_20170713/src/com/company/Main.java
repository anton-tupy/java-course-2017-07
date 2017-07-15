package com.company;

import com.company.pkg.One;

public class Main {

    public static void main(String[] args) {
	 Greeter greeter1 = new Greeter("Good morning");
	 greeter1.greet();
	 greeter1.greet("Vasya!");

	 Greeter greeter2 = new Greeter();
	 greeter2.greet("Lena");

	 Greeter gretter3 = new com.company.Greeter("Hello!");
    }


}
