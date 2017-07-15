package com.company;

import java.io.IOException;
import java.util.Random;

/**
 * Created by mitya murasov on 13.07.2017.
 */
public class Task
{
    public static void main(String[] args) throws IOException
    {
        Random random = new Random();
        int number = random.nextInt(100);
        //System.out.println(number);
        int i = 0;
        TaskInterface interfacez = new TaskInterface(number);
        while ( i < 7)
        {
            System.out.println("Попытка " + (i+1) + " из 7");
            int x = interfacez.inter();
            //System.out.println("Принято: " + x);
            if ( x == number)
            {
                System.out.println("Угадали");
                break;
            }
            else if ( x > number)
            {
                System.out.println("Попробуйте Меньше");
                i++;
            }
            else if ( x < number)
            {
                System.out.println("Попробуйте Больше");
                i++;
            }
        }
    }
}
