import java.util.concurrent.Callable;

/**
 * User: Alexandr
 * Date: 05.10.2014
 */
public class NewCar {

    public static void main(String[] args) {
        String s1 = new String("AbcdF");
        String s2 = new String("AbcdF");

        System.out.println("Длина строки");
        System.out.println(s1.length());
        System.out.println();

        System.out.println("Сравнение объектов");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println();

        System.out.println("Поиск подстроки");
        System.out.println(s1.contains("g"));
        System.out.println(s1.contains("F"));
        System.out.println(s1.contains("f"));
        System.out.println(s1.contains("bcd"));
        System.out.println();

        System.out.println("Поиск символа по номеру");
        System.out.println(s1.indexOf("F"));
        System.out.println(s1.lastIndexOf("F"));
        System.out.println();

        System.out.println("Приведение к верхнему и нижнему регистру");
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());
        System.out.println();

        System.out.println("Умный поиск и сравнение");
        System.out.println(s1 + " поиск f: " + s1.toLowerCase().contains("f"));
        System.out.println();

        System.out.println("Обрезать строку");
        System.out.println(s1.substring(2, 4)); //обезать со 2 по 4 символы
        System.out.println(s1.substring(1)); //обрезать с 1 и до конца
        System.out.println();

        System.out.println("Разбить строку на подстроки по условию");
        String[] array = s1.split("c");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println();


        String sss = "a";
        for (int i = 0; i < 10; i++) {
            sss += "b";
        }

        System.out.println(sss);

    }
}
