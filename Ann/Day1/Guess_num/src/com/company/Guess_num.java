package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Guess_num {

    public static void main(String[] args) throws IOException {
        InputStreamReader reeder = new InputStreamReader(System.in);
        BufferedReader bufferReader = new BufferedReader(reeder);
        int number_to_find1 = Calcs.getNum(100);
        System.out.println("Мы загадали число от 1 до 100. Угадай с 8-ми раз!");

        int number_chance1 = 8;
        int number_chance_cnt1 = 1;

        while(number_chance_cnt1 <= number_chance1) {
            String line = bufferReader.readLine();
            if (line == null || line == ""){
                break;
            }
            int number_find1 = Integer.valueOf(line);

            String str_ans1 = Calcs.getAnswer(number_to_find1, number_find1, number_chance_cnt1,number_chance1);
            System.out.println(str_ans1);
            if (str_ans1 == "Бинго!"){
                break;
            }
            number_chance_cnt1++;
        }
    }
}
