package com.company;


public class Husband extends Family {
    private final String name;
    private final int age;

    public Husband (String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void person() {
        System.out.println("Меня зовут " + name + " мне: " + age + " лет.");
    }
}
