/*
 * Sara Hrnciar
 * CSC 301 Prog2
 * Dr. Lori
 * Program containing BST, AVL, and Red black trees. 
 * file defined in line 25
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 import java.io.*;
 //Special thanks to the man on stack overflow who taught me how to set up a clock in java!
 //https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java
 public class BinaryTreeTester {
    static String book;
    public static void PopulateTree(BinaryTree tree, String fileName, int type){
        File strings = new File("SciFiLiBooks.txt");
        switch (type) {
            case 1:
                try (Scanner sc = new Scanner(strings)){ 
                    while (sc.hasNextLine()){
                        book = sc.nextLine();
                        tree.insert(new BinNode(book));
                    }
                }catch (FileNotFoundException e){
                    System.err.println(e);
                }
                break;
            case 2:
                try (Scanner sc = new Scanner(strings)){ 
                    while (sc.hasNextLine()){
                        book = sc.nextLine();
                        tree.insert(new avlBinNode(book));
                    }
                }catch (FileNotFoundException e){
                    System.err.println(e);
                }
                break;
            case 3:
                try (Scanner sc = new Scanner(strings)){ 
                    while (sc.hasNextLine()){
                        book = sc.nextLine();
                        tree.insert(new RBNode(book));
                    }
                }catch (FileNotFoundException e){
                    System.err.println(e);
                }

                break;
            default:
                break;
        } 

    }
     public static void main(String args[]){

        //PART A : CREATING THE TREE

         BinaryTree b = new BinaryTree();
         RedBlackTree rb = new RedBlackTree();
         AVLTree a = new AVLTree();

         long binaryTime = System.nanoTime();
         PopulateTree(b,"SciFiLiBooks.txt", 1);
         binaryTime =System.nanoTime() - binaryTime;

         long AVLTime = System.nanoTime();
         PopulateTree(a, "SciFiLiBooks.txt",2);
         AVLTime =System.nanoTime() -AVLTime;
         
         long RBTime = System.nanoTime();
         PopulateTree(rb, "SciFiLiBooks.txt",3);
         RBTime =System.nanoTime() -RBTime;
         
         System.out.println("See below for time taken to populate trees");
         System.out.println("Binary tree took " + binaryTime + " nanoseconds");
         System.out.println("AVL tree took " + AVLTime + " nanoseconds");
         System.out.println("Red black tree took " +RBTime + " nanoseconds");

            String binaryIdeal = "binary was fast as hell!";
            String avlIdeal = "Avl was fast as hell!";
            String rbIdeal = "red black was fast as hell!";
            System.out.println(binaryTime<AVLTime && binaryTime<RBTime ? binaryIdeal : (AVLTime < RBTime ? avlIdeal : rbIdeal));
            System.out.println("\n\n\n");


            //PART B: Deleting a node that doesnt exist 
            binaryTime = System.nanoTime();
            b.search("kakakakakffkkk");
            binaryTime =System.nanoTime() - binaryTime;
   
            AVLTime = System.nanoTime();
            a.search("bookadok");
            AVLTime =System.nanoTime() -AVLTime;
            
            RBTime = System.nanoTime();
            rb.search("meep meepm eepp");
            RBTime =System.nanoTime() -RBTime;

            System.out.println("See below for time taken to delete nonexistant vals");
            System.out.println("Binary tree took " + binaryTime + " nanoseconds");
            System.out.println("AVL tree took " + AVLTime + " nanoseconds");
            System.out.println("Red black tree took " +RBTime + " nanoseconds");
            System.out.println(binaryTime<AVLTime && binaryTime<RBTime ? binaryIdeal : (AVLTime < RBTime ? avlIdeal : rbIdeal));System.out.println("\n\n\n");
            System.out.println("\n\n\n");


            //PART C: Removing a real life book!
            binaryTime = System.nanoTime();
            b.remove("Ready Player One");
            binaryTime =System.nanoTime() - binaryTime;
   
            AVLTime = System.nanoTime();
            a.remove("Ready Player One");
            AVLTime =System.nanoTime() -AVLTime;
            
            RBTime = System.nanoTime();
            rb.remove("Ready Player One");
            RBTime =System.nanoTime() -RBTime;

            System.out.println("See below for time taken to delete real vals");
            System.out.println("Binary tree took " + binaryTime + " nanoseconds");
            System.out.println("AVL tree took " + AVLTime + " nanoseconds");
            System.out.println("Red black tree took " +RBTime + " nanoseconds");
            System.out.println(binaryTime<AVLTime && binaryTime<RBTime ? binaryIdeal : (AVLTime < RBTime ? avlIdeal : rbIdeal));System.out.println("\n\n\n");
            System.out.println("\n\n\n");

     }   
 }
 