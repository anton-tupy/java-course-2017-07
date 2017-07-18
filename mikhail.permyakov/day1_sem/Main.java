package com.jcourse.permyakov;

import java.util.Properties;

/**
 * Created by vsev on 18.06.2014.
 */
public class Main extends Object {

    public static void main (String args[]) {
        for (int i = 0; i<args.length; i++) {
            System.out.println("args[" + i + "]=" + args[i]);
        }
        System.out.println(" Current system properties: ");
        Properties props = System.getProperties();
        for (String name:  props.stringPropertyNames()) {
            System.out.println(" name: "+name+ " value = "+props.getProperty(name));
        }
        //System.exit(10);
    }

}
