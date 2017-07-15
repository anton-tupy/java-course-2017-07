package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by mitya murasov on 13.07.2017.
 */
public class TaskInterface
{
    private int value;

    public TaskInterface(int value)
    {
        this.value = value;
    }

    public int inter() throws IOException
    {

            System.out.println("Введите число: ");
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp1 = bufferedReader.readLine();
            int temp2 = Integer.parseInt(temp1);
            return temp2;

    }
}
