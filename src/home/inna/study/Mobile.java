package home.inna.study;

/**
 * User: Alexandr
 * Date: 25.10.2014
 */
public class Mobile {
    private int yas1;
    private int ina;
    private int last2;


    public Mobile(int yas1, int ina) {
        this.yas1 = yas1;
        this.ina = ina;
    }

    public int next() {
        if (yas1 == last2) {
            last2 = ina;
        } else {
            last2 = yas1;
        }
        return last2;
    }
}