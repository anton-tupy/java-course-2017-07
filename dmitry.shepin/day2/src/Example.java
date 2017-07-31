/**
 * Created by Dmitry on 19.07.2017.
 */

 class Parent {
    private final static int a = 5;

    public static void f() {
        System.out.println("М");
    }

    public  void a() {
        System.out.println("a");
    }



}


class Child extends Parent {
    private final static int a = 6;


    public static void f() {
        System.out.println("Метод от Parent");
    }

    public  void a() {
        System.out.println("нестатик child");
    }
}


public class Example {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent=child;

        child.a();
        child.a();

        Child.f();
        Parent.f();


    }
}
