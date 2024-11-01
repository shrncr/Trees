
/*
 * Converted my tester class from python to java
 * Thank you chat gpt <3
 */
import java.util.Random;

public class BinaryTreeTester {
    public static void main(String[] args) {
        Random random = new Random();

        AVLTree Treeson = new AVLTree(new avlBinNode("Sara"));

        System.out.println(Treeson);

        Treeson.insert(new avlBinNode("Mason"));
        System.out.println(Treeson);

        Treeson.insert(new avlBinNode("Chinchi"));
        System.out.println(Treeson);

        Treeson.insert(new avlBinNode("Toothpick"));
        System.out.println(Treeson);

        Treeson.insert(new avlBinNode("Kinga"));
        System.out.println(Treeson);
        Treeson.insert(new avlBinNode("Tyffy"));
        System.out.println(Treeson);
        Treeson.insert(new avlBinNode("a"));
        System.out.println(Treeson);

        Treeson.remove("Mason");
        System.out.println(Treeson);

        System.out.println("MASON NOOOOOOO");


    }
}
