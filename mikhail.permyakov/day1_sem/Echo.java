package com.jcourse.permyakov;

import java.io.*;


/**
 * Created by lab on 13.07.2017.
 */
public class Echo {


    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        while(true) {
            String line = br.readLine();
            if (line == null){
                break;
            }
            System.out.println(line);
        }
        br.close();
        reader.close();
    }
}
