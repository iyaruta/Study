import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 17.09.2014
 */
public class Sell {
    public static void main(String[] args) {
    String name = new String("Inna, Yasya, Andrey");
    String name2 = new String("Alexandr Rudenko");
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());
        System.out.println();

        System.out.println(name.toLowerCase().contains("i"));
        System.out.println(name.toUpperCase().contains("N"));
        System.out.println();


        String[] array = name.split(" ");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println();

        System.out.println(name.length());
        System.out.println();

        System.out.println(name.toLowerCase().indexOf("y"));
        System.out.println(name.indexOf("y"));
        System.out.println(name.lastIndexOf("d"));
        System.out.println(name.toLowerCase().indexOf("d")); //
        System.out.println();

        System.out.println(name.substring(6));
        System.out.println(name.substring(6, 11));
        System.out.println();

        System.out.println(name.equals(name2));

    }

}