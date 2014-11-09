/**
 * User: Alexandr
 * Date: 05.10.2014
 */
public class Car {
    String name;
    Car parent;
    Car[] children;
    Car[] cousin;
    Car[] sister;

    public Car(String carName) {
        name = carName;
    }

    public Car(String name, Car[] children, Car[] cousin, Car[] sister, Car parent ) {
        this.name = name;
        this.children = children;
        this.cousin = cousin;
        this.sister = sister;
        this.parent = parent;

//        this.children. = this;
    }
}
