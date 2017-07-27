package com.company;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //Создание класса класс:
        Class animalClass = Animal.class; //
        System.out.println("Class name = " + animalClass.getSimpleName());
        System.out.println("Class full name = " + animalClass.getName());
        System.out.println(animalClass.getMethod("jump"));

        //Получение класса по полному имени:
        Class animalClass2 = Class.forName("com.company.Animal");
        System.out.println("Class2 full name=" + animalClass2.getName());

        Object cat = animalClass2.newInstance(); //динамическое создание класса(создание экземпляра)
        Class catClass = cat.getClass();
        System.out.println("Object class=" + catClass.getName());

        Runner animal = (Runner) cat; //Приведение типа
        animal.run();
        System.out.println();

        Method runMethod = catClass.getMethod("run");
        runMethod.invoke(cat);


        Field speedsField = catClass.getDeclaredField("speed");
        speedsField.setAccessible(true);

        int speedValue = speedsField.getInt(cat);
        System.out.println("Speed = " + speedValue);

        speedsField.setInt(cat, 20);
        runMethod.invoke(cat);

        Runner proxy = (Runner) Proxy.newProxyInstance(
                Main.class.getClassLoader(), new Class[]{Runner.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Called method:" + method.getName());
                        return null;
                    }
                });
        proxy.run();
        proxy.jump();

        Object s = "123";
        Class c = s.getClass();

        Class v = Class.forName("java.lang.String");
        System.out.println(v);


    }
}
