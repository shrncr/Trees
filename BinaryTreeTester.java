
/*
 * Converted my tester class from python to java
 * Thank you chat gpt <3
 */
import java.util.Random;

public class BinaryTreeTester {
    public static void main(String[] args) {
        Random random = new Random();

        RedBlackTree Treeson = new RedBlackTree(new RBNode("S"));

        System.out.println(Treeson);

        Treeson.insert(new RBNode("M"));
        System.out.println(Treeson);

        Treeson.insert(new RBNode("C"));
        System.out.println(Treeson);

        Treeson.insert(new RBNode("T"));
        System.out.println(Treeson);

        Treeson.insert(new RBNode("K"));
        System.out.println(Treeson);
        Treeson.insert(new RBNode("T"));
        System.out.println(Treeson);
        System.out.println("\n\n\n\n");
        Treeson.insert(new RBNode("A"));
        System.out.println(Treeson);

         Treeson.remove("M");
         System.out.println(Treeson);


    }
}
