package book;

import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 13.10.2014
 */
public class Phonebook {

    private Mobile[] mobiles;
    private int size;

    public Phonebook() {
        mobiles = new Mobile[10];
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        Mobile mobile = new Mobile();
        System.out.print("Имя: ");
        mobile.firstname = sc.next();
        System.out.print("Фамилия: ");
        mobile.lastname = sc.next();
        System.out.print("Телефон: ");
        mobile.phone = sc.next();
        System.out.print("Адрес: ");
        mobile.address = sc.next();
        System.out.print("День рождение: ");

        mobile.birthday = sc.next();
        mobiles[size] = mobile;
        size++;
    }

    public void add(String firstname, String lastname, String phone, String address, String birthday) {
        Mobile mobile = new Mobile();
        mobile.firstname = firstname;
        mobile.lastname = lastname;
        mobile.phone = phone;
        mobile.address = address;
        mobile.birthday = birthday;
        mobiles[size] = mobile;
        size++;
    }

    public void view() {
        find(null);
    }

    public void remove(int index) {
        if ((index > 0) && (index <= size)) {
            while (index < size) {
                mobiles[index - 1] = mobiles[index];
                index++;
            }
            size--;
            mobiles[size] = null;
        } else {
            System.out.println("такой записи нет");
        }
    }

    public void find(String query) {
        for (int i = 0; i < size; i++) {
            if (query == null || isVisible(mobiles[i], query)) {
                System.out.print(i + 1 + ". ");
                System.out.print(mobiles[i].firstname + " ");
                System.out.print(mobiles[i].lastname + " ");
                System.out.print(mobiles[i].phone + " ");
                System.out.print(mobiles[i].address + " ");
                System.out.print(mobiles[i].birthday + " ");
                System.out.println();
            }
        }
        System.out.println();
    }

    private boolean isVisible(Mobile mobile, String query) {
        String queryLow = query.toLowerCase();
        return mobile.firstname.toLowerCase().contains(queryLow)
                     || (mobile.lastname.toLowerCase().contains(queryLow))
                     || (mobile.phone.toLowerCase().contains(queryLow))
                     || (mobile.address.toLowerCase().contains(queryLow))
                     || (mobile.birthday.toLowerCase().contains(queryLow));

    }
}

