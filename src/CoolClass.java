/**
 * User: Alexandr
 * Date: 07.10.2014
 */
public class CoolClass {

    public static void main(String[] args) {
        CoolClass object = new CoolClass();
        int result = object.power(2, 8);
        System.out.println(result);

    }

    public int power(int x, int n) {
        int result = x;
        while (n > 1) {
            result *= x;
            n--;
        }
        return result;
    }

}
