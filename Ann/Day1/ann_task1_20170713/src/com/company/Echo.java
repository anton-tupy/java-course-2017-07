package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by It-Academy-5 on 13.07.2017.
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        InputStreamReader reeder = new InputStreamReader(System.in);
        BufferedReader bufferReader = new BufferedReader(reeder);
        while(true) {
            String line = bufferReader.readLine();
            if (line == null){
                break;
            }
            System.out.println(line);
        }
    };

}
