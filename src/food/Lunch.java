package food;

/**
 * User: Alexandr
 * Date: 19.11.2014
 */
public class Lunch {
    public static void main(String[] args) {
//        Drinks drinksMane = new Drinks();
//        drinksMane.getIngridients();

        Fruit fruit = new Fruit();
        fruit.drinkables(new Vegetables());

        Desserts desserts = new Desserts();
        desserts.setName("шоколад");

        fruit.setName("апильсин");
        printName(fruit);
        printName(desserts);
    }
    public static void printName(Drinks drinks) {
        System.out.println(drinks.getName());}
}
