package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class animalClass = Animal.class;
//        System.out.println("Class name: " + animalClass.getSimpleName());
//        System.out.println("Class full name: " + animalClass.getName());
        Class<?> animalClass2 = Class.forName("com.company.Animal");
        System.out.println("Class2 full name:" + animalClass2.getName());
        Object obj = animalClass2.newInstance();
        Class<?> objClass = obj.getClass();
        System.out.println("Object class: " + objClass.getName());
//        Runner animal = (Runner) obj;
//        animal.run();

        Method runMethod = objClass.getMethod("run");
        runMethod.invoke(obj);
    }
}
