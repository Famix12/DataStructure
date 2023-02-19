
import java.util.Scanner;
import java.util.*;

public class TestIntegerBST {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        int option, target;

        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("\n***************************");
            System.out.println("*   Testing Binary Search Tree *");
            System.out.println("***************************\n");
            System.out.println("1.  Insert an element");
            System.out.println("2.  Search for an element");
            System.out.println("3.  Delete an element");
            System.out.println("4.  Print in Breadth-First-Order");
            System.out.println("5.  Print in Pre-Order");
            System.out.println("6.  Print in In-Order");
            System.out.println("7.  Print in Post-Order");
            System.out.println("8.  Print height of the tree");            
            System.out.println("9.  Print sum of the elements"); //using iterator
            System.out.println("10.  Quit");

            System.out.print("\nSelect an Option [1...10] : ");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    tree.insert(reader.nextInt());
                    new BSTPrinter(tree).print(); //print the tree
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
                    new BSTPrinter(tree).print(); //print the updated tree
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
                     System.out.print("The height of the tree is: " + tree.getHeight());
                     break;
                case 9:
                    System.out.print("Sum of the elements in the tree is: " + sum(tree));
                    break;
          } //end of switch

        } while (option != 10);
    } //end of main

    public static int sum(BST<Integer> tree) {
        int sum = 0;
        for (int n : tree) {
            sum += n;
        }
        return sum;
    }
}
