package com.company;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

//        Class animalClass = Animal.class; //
//        System.out.println("class name= "+ animalClass.getSimpleName());  // метод класса Class
//        System.out.println("class full name= "+ animalClass.getName());

        Class<?> animalClass2 =  Class.forName("com.company.Animal");  //загружаем класс по названию
        System.out.println("Class2 full name= "+ animalClass2.getName());

        Object obj = animalClass2.newInstance();      // объект от класса который открыли по названию
        Class<?> objClass = obj.getClass();
        System.out.println("Oblect class: "+ objClass.getName());

        Method runMethod = objClass.getMethod("run");  //runMethod - объект класса Method предоставляющий доступ к методу(определенному)
        runMethod.invoke(obj); // вызов метода

//        Runner animal = (Runner) obj;
//        animal.run();
        Field speedField= objClass.getDeclaredField("speed");
        speedField.setAccessible(true); // позволяет получить доступ к приватному полю
        int speedValue= speedField.getInt(obj);
        System.out.println("speed= " + speedValue+ "km/h");
        speedField.setInt(obj, 20);  //поменяли значение поля speed
        runMethod.invoke(obj);

        Runner proxy= (Runner)Proxy.newProxyInstance( //1-й пар-р класс лоадер, 2-й пар-р интерфейсы которые хотим реализовать, 3-й обрабатывает вызов методов
                Main.class.getClassLoader(), new Class[]{Runner.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println("Called method "+ method.getName());
                        return null;
                    }
                });
        proxy.run();

    }
}
