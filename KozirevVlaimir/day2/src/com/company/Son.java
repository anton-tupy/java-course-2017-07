package com.company;


public class Son extends Family {
    private String name;
    private int age;

    public Son (String name,int age){
        this.name = name;
        this.age = age;
    }


    @Override
    public void person() {
        System.out.println("Меня зовут " + name + " мне: " + age + " лет.");
    }

}
