import java.util.Scanner;
import java.io.*;
import java.util.*;

public class TestIntegerAVL {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        int option, target;

        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("\n***************************");
            System.out.println("*   Testing AVL Tree *");
            System.out.println("***************************\n");
            System.out.println("1.  Insert an element");
            System.out.println("2.  Search for an element");
            System.out.println("3.  Delete an element");
            System.out.println("4.  Print in Breadth-First-Order");
            System.out.println("5.  Print in Pre-Order");
            System.out.println("6.  Print in In-Order");
            System.out.println("7.  Print in Post-Order");
            System.out.println("8.  Clear the tree");
            System.out.println("9.  Quit");

            System.out.print("\nSelect an Option [1...9] : ");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    tree.insert(reader.nextInt());
                    new AVLTreePrinter(tree).print(); //print the tree
                    break;

                case 2:
                    System.out.print("Enter the element to search for: ");
                    target = reader.nextInt();
                    Integer result = tree.search(target);
                    if (result != null) {
                        System.out.println("Element, " + result + " was found in the tree");
                    } else {
                        System.out.println("Sorry, the element was not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter the element delete: ");
                    tree.delete(reader.nextInt());
                    new AVLTreePrinter(tree).print(); //print the tree
                    break;

                case 4:
                    tree.breadthFirst();
                    break;

                case 5:
                    tree.preorder();
                    break;

                case 6:
                    tree.inorder();
                    break;

                case 7:
                    tree.postorder();
                    break;

                case 8:
                    tree.clear();
                    break;
            } //end of switch

        } while (option != 9);
    } //end of main
}
