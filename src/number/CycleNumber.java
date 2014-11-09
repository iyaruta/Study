package number;

import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 08.11.2014
 */
public class CycleNumber {

    private int one;
    private int two;
    private int last = -1;

    public CycleNumber(int one, int two) {
        this.one = one;
        this.two = two;
    }

    public int next() {
        if (one == last) {
            last = two;
        } else {
            last = one;
        }
        return last;
    }

}