/**
 * User: Alexandr
 * Date: 07.10.2014
 */
public class Node {

    public String name;
    public Node parent;
    public Node left;
    public Node right;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, Node left, Node right, Node parent) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.parent = parent;

        this.left.parent = this;
        this.right.parent = this;
    }
}
