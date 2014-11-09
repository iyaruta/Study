package book;

import java.io.IOException;
import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 13.10.2014
 */
public class Main {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        phonebook.add("Alex", "Rudenko", "+380979522716", "Donca 19 Str","16 ноября " );
        phonebook.add("Inna", "Yaruta", "+380975554455", "Donca 19 Str","8 квітня" );
        phonebook.add("Yaroslava", "Rudenko", "+380971927225", "Donca 19 Str", "1 червня");


        boolean visible = true;
        while (true) {
            if (visible) {
                showMenu();
            }

            visible = true;
            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();
                if (command == 1) {
                    phonebook.add();
                } else if (command == 2) {
                    phonebook.view();
                } else if (command == 3) {
                    phonebook.remove(scanner.nextInt());
                } else if (command == 0) {
                    System.exit(0);
                } else if (command == 4){
                     phonebook.find(scanner.next());
                } else {
                    System.out.println("Неверная команда");
                    visible = false;
                }
            } else {
                System.out.println("Неверная команда");
                scanner.next();
                visible = false;
            }
        }

    }


    public static void showMenu() {
        System.out.println("1. Добавить запись");
        System.out.println("2. Просмтреть справочник");
        System.out.println("3. Удалить запись");
        System.out.println("4. Найти запись");
        System.out.println("0. Выйти");

    }
}
