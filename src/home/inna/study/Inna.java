package home.inna.study;

import book.Phonebook;

import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 25.10.2014
 */
public class Inna {

    int[] game;

    public Inna() {
        game = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,};
    }

    public void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                if (game[i] == 2) {
                    System.out.println("_ ");
                }
            }
        }
    }
    public void cross() {
        Scanner sc = new Scanner(System.in);

    }
}
