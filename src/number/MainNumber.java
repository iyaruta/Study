package number;

import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 08.11.2014
 */
public class MainNumber {

    public static void main(String[] args) {
        int ONE =  5;
        int TWO =  7;
        CycleNumber cycleNumber = new CycleNumber(ONE, TWO);

        System.out.println(cycleNumber.next()); //5
        System.out.println(cycleNumber.next()); //7
        System.out.println(cycleNumber.next()); //5
        System.out.println(cycleNumber.next()); //7
    }

}
