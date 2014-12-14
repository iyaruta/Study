package inheritance.e2;

/**
 * User: Alexandr
 * Date: 19.11.2014
 */
public class ConsoleWriter extends Writer {

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
