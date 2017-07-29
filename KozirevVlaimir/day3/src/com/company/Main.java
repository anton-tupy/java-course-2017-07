package com.company;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class animalClass = Animal.class;
        System.out.println("Class name " + animalClass.getSimpleName());
        System.out.println("Class full name " + animalClass.getName());

        Class<?> animalClass2 = Class.forName("com.company.Animal");
        System.out.println("Class2 full name: " + animalClass2.getName());
        Object obj = animalClass2.newInstance();
        Class<?> objClass = obj.getClass();
        System.out.println("Object class: " + objClass.getName());

       // Runner animal = (Runner) obj;
        //animal.run();

        Method runMetod = objClass.getMethod("run");
        runMetod.invoke(obj);

        Field speedField = objClass.getDeclaredField("speed");
        speedField.setAccessible(true);
        int speedValue = speedField.getInt(obj);
        System.out.println("Speed: " + speedValue);

        speedField.setInt(obj,20);
        runMetod.invoke(obj);

        Runner proxy = (Runner)Proxy.newProxyInstance(Main.class.getClassLoader(),new Class[]{Runner.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Called metod: " + method.getName());
                return null;
            }
        });
        proxy.run();

    }
}
