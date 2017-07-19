package com.jcourse.permyakov;

/**
 * Created by lab on 13.07.2017.
 */
public class Greeter {

    private String greet;

    public Greeter(String greet){
        this.greet = greet;
    }

    public Greeter(){
        this.greet = "arght";
    }

        public void greet(){
            System.out.println("hello from greeter");
        }
        public void greet(String name){
            System.out.println(greet + name);
        }
}
