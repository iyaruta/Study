package home.inna.study;

import book.Phonebook;

import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 25.10.2014
 */
public class Inna {
    public static void main(String[] args){
        int yasya = 3;
        int in = 4;
        Mobile mobile = new Mobile(yasya, in);

        System.out.println(mobile.next());
        System.out.println(mobile.next());
        System.out.println(mobile.next());

    }

}
