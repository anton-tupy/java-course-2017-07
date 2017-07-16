package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by IT-Academy on 13.07.2017.
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while(true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        bufferedReader.close();
        reader.close();

        Random random = new Random();
        int number = random.nextInt(100);

        Integer.valueOf("1");
        Integer.parseInt("2");
    }
}
