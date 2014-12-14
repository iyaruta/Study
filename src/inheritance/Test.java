package inheritance;

/**
 * User: Alexandr
 * Date: 18.11.2014
 */
public class Test {

    public static void main(String[] args) {
        Wolf wolfMale = new Wolf();
        wolfMale.setGender(1);
        Wolf wolfFemale = new Wolf();
        Animal baby = wolfFemale.sex(wolfMale);



        Animal animal = new Wolf();
        Wolf wolf = new Wolf();

        wolf.eat(new Sheep());


        Sheep sheep = new Sheep();
        sheep.setName("Black sheep");

        wolf.setName("Grey wolf");
        printName(wolf);
        printName(sheep);
    }


//    public static void printName(Sheep sheep) {
//        System.out.println(sheep.getName());
//    }

    public static void printName(Animal animal) {
        System.out.println(animal.getName());
    }

}
