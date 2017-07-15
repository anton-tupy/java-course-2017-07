package com.company;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by mitya murasov on 13.07.2017.
 */
public class Echo
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while(true)
        {
            //System.out.println("Ввелите число: ");
            String temp1 = bufferedReader.readLine();
            if (temp1 == null)
            {
                break;
            }
            //double temp2 = Integer.parseInt(temp1);
        }
        bufferedReader.close();
        reader.close();
    }
}
