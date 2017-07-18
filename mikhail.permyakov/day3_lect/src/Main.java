//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.*;

abstract class Parent
{
    //static field realizes class state and shared among all objects of the class
    //static field is initialized when class has been loaded into JVM
    public static final int i = 10;
    //static block is executed when class has been loaded into JVM
    static   {
        System.out.println("Parent static initializer");
    }
    //dynamic initialization block executed before constructor when object is initialized
    {
        System.out.println("Parent non static initializer");
    }

    protected Parent()
    {
        //super();
        System.out.println("Parent constructor");
        //"Class" object corresponds to real objects class
        System.out.println("object class: "+this.getClass().getName());
        System.out.println(g());
        doIt(); // danger!
    }

    //static method realizes class behaviour and executed without object context
    //"this" reference cannot be used inside static context
    static String  g() {
        return  "static Parent.g()";
    }
    //abstract method should be implemented by derived class
    public abstract void doIt();
}

class Derived extends Parent
{
    //Derived specifies its own static field i, which hides Parent.i
    public static final int i = 20;
    static   {
        System.out.println("Derived static initializer");
    }
    {
        System.out.println("Derived non static initializer");
    }

    public Derived()
    {
        this(0);
        //super(); //call super class (i.e. Parent) constructor
        System.out.println("Derived() constructor");
    }

    protected Derived(int j) {
        super();
        System.out.println("protected Derived("+j+") constructor");
    }

    //doIt implements (overrides) base abstract method doIt defined in Parent class
    @Override
    public void doIt() {

        System.out.println("Derived.doIt()");
    }
    //static method hides, not overrides,  static method Parent.g()
    public static String g() {
        return "static Derived.g()";

    }
}


public class Main {
    static {
        System.out.println("Thread name: "+Thread.currentThread().getName());
        System.out.println("is Daemon thread? "+Thread.currentThread().isDaemon());
        System.out.println("static Main initializer");
    }
    public static void main(String[] args) throws Exception {
        //Main static block already executed at this moment when Main class is loaded upon JVM start
        System.out.println("main()");
        System.out.println("Thread name: "+Thread.currentThread().getName());

        //System.out.println(Thread.currentThread().getName());
        //Here Derived class is loaded to JVM, its superclass is loaded too, before it
        //Both their static blocks are executed here
        //then Parent non static block executed followed by Parent constructor
        //and after that, Derived non static block and constructor executed
        Derived d = new Derived();
        //p references same object with reference of Parent type
        Parent p = d;
        System.out.println("p references "+p);
        System.out.println("d references "+d);

//        //static field is bound to reference type, regardless of the real object type
        System.out.println("d.i = "+d.i); //Derived.i //20
        System.out.println("p.i = "+p.i);  //Parent.i 10
//
//        //virtual non static function is called according to real object class (i.e. Derived.doIt())
        p.doIt();
        d.doIt();
//
//        //static function is bound to reference type, not the objects' type
        System.out.println(p.g());  // Parent.g();
        System.out.println(d.g());   // Derived.g();


        //final local variable can be accessed in local class
        final int k=1000;
        //int k=1000;
//
//        //object of anonymous local class derived from Derived is created here
        System.out.println("Lets work with anonymous local class derived from Derived");
        Parent localParent = new Derived (5)
        {

            {
                System.out.println("Anonymous initializer");
                System.out.println("our class: "+getClass().getName());

            }

            public void doIt() {
                System.out.println("Anonymous doIt() , k== "+k);
                System.out.println("calling function from super class "
                        +this.getClass().getSuperclass().getName()+" :");
                super.doIt();
//                try {
//                    Method m = this.getClass().getSuperclass().getSuperclass().getMethod("doIt");
//                    m.invoke(this);
//
//                } catch (Exception ex) {
//                    System.err.println("ex: "+ex);
//                }
            }
        };

        //virtual function which is overriden in anonymous class is called
        localParent.doIt();
////
////// //Practical example for anonymous local class:
        JFrame f  = new JFrame("Title goes here");

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton b = new JButton("one");
    // button will change its label when pressed
        b.addActionListener(new ActionListener() {
            private int count=0;
            public void actionPerformed(ActionEvent e) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("is daemon: "+Thread.currentThread().isDaemon());

                ((JButton)e.getSource() ).setText("two "+(count++));
                f.pack();
            }
        });
//        b.addActionListener(e -> {
//            System.out.println("Thread: "+Thread.currentThread().getName());
//            ((JButton)e.getSource() ).setText("three");
//        });
        f.getContentPane().add(b);
        f.pack();
        f.setVisible(true);
       // Thread.sleep(100000);
////

    String strings[] = new String[]{"one", "two", "three"};
    List<String> list = new ArrayList<String>();
        for (String s: strings) list.add(s);

        Collections.sort(list, new Comparator<String> (){

        @Override
            public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
        });
//    Collections.sort(list, (o1,o2)-> { return o2.compareTo(o1); });
    for (String s: list) {System.out.println(s);}
////
    }
}