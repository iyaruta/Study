/**
 * User: Alexandr
 * Date: 04.09.2014
 */
public class Keep {
    public static void main(String[] args) {
        Seek root = new Seek();
        root.name = "vasya";

        Seek seek2 = new Seek();
        Seek seek2_1 = new Seek();
        seek2.name = "anya";
        seek2_1.name = "mareena";

        Seek seek3 = new Seek();
        Seek seek3_1 = new Seek();
        Seek seek3_2 = new Seek();
        Seek seek3_3 = new Seek();
        seek3.name = "inna";
        seek3_1.name = "yasya";
        seek3_2.name = "sacha";
        seek3_3.name = "veec";

        root.right = seek2_1;
        seek2_1.right = seek3_3;
        seek2_1.left = seek3_2;

        root.left = seek2;
        seek2.left = seek3;
        seek2.right = seek3_1;


        Keep keep = new Keep();
        int count = keep.count(root, 0);
        System.out.println(count + " elements");

        Seek[] holder = {root};
        int capacity = 1;
        int i = 1;
        int u = 1;
        if (root == null) {
            i = 0;
            u = 0;
            capacity = 0;
        }


//          while (capacity != 0) {
//              Seek[] newHolder = new Seek[capacity * 2];
//               int newCapacity = 0;
//               for (int j = 0; j < capacity; j++) {
//                   Seek left = holder[j].left;
//                   if (left != null){
//                       newHolder[newCapacity] = left;
//                       newCapacity++;
//                       i++;
//                   }
//                    Seek right = holder[j].right;
//                    if (right != null){
//                        newHolder[newCapacity] = right;
//                        newCapacity++;
//                        i++;
//                }
//            }

        while (capacity != 0){
            Seek[] newHolder = new Seek[capacity * 2];
            int newCapacity =0;
            for (int y = 0, o = newCapacity; y < capacity; y++, o--){
                Seek left = holder[y].left;
                if(left != null){
                    newHolder[newCapacity] = left;
                    newCapacity++;
                    i++;
                } else{
//                    for (int r = newCapacity; r > capacity; r--){
                        Seek right = holder[o].right;
                        if(right != null){
                            newHolder[newCapacity] = right;
                            newCapacity++;
                            u++;
                        }
//                    }
                }
            }




            holder = newHolder;
            capacity = newCapacity;

        }
        System.out.println(u);
        System.out.println(i);
//      System.out.println(root.name);
//      System.out.println(root.right.name);
//      System.out.println(seek2_1.left.name);


    }

    public int count(Seek seek, int count) {
        if (seek == null) {
            return count;
        }

        count++;
        if (seek.left != null) {
            count(seek.left, count);
        }

        return count(seek.right, count);
    }
}



