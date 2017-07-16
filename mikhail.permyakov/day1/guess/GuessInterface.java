package com.jcourse.permyakov.guess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessInterface {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    do {
        GuessLogic gl = new GuessLogic();
        while (gl.getAttempts() > 0) {
            System.out.println("You have " + gl.getAttempts() + " attempts left. \nMake your guess:\n");
            gl.setUserGuess(Integer.parseInt(bufferedReader.readLine()));
            if (gl.isHumanWon(gl.getUserGuess())) {
                System.out.println(gl.getCongratsMessage(gl.getWinner()));
                break;
            }
            gl.setAttempts(gl.getAttempts() - 1);
            if (gl.getAttempts() > 0) gl.printFeedBack(gl.getUserGuess());
        }
        if (gl.getWinner() != GuessLogic.HUMAN) {
            gl.setWinner(GuessLogic.COMPUTER);
            System.out.println(gl.getCongratsMessage(gl.getWinner()));
        }
        System.out.println("Do you want to continue? (y/n)");

    } while (bufferedReader.readLine().equals("y"));
        System.out.println("Ok. bye!");
        }
    }