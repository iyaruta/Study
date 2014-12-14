package inheritance;

/**
 * User: Alexandr
 * Date: 18.11.2014
 */
public class Animal {

    private String name;
    private int gender;
    private int age;

    public Animal sex(Animal partner) {
        if (gender == partner.gender) {
            System.out.println("ПИДАРАСЫ!");
            return null;
        }
        return new Animal();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
