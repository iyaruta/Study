package xo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * User: Alexander Rudenko
 * Date: 08.12.14
 */
public class Test2 {
    public static void main(String[] args) {
        Collection<String> collection = new HashSet<>();
        collection.add("a");
        collection.add("a");
        collection.add("a");
        collection.add("a");
        collection.add("a");
        collection.add("a");
        collection.add("a");
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.add("d");

        for (String name :collection){
            System.out.println(name);

        }

    }

}
