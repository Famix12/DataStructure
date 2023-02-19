
import java.util.Scanner;

public class TestIntegerDLL {

    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        int option, target;

        Scanner stdin = new Scanner(System.in);

        do {
            System.out.println("\n***************************");
            System.out.println("   Testing Integer DLL  ");
            System.out.println("***************************");
            System.out.println("1.  Add Node at Head");
            System.out.println("2.  Add Node at Tail");
            System.out.println("3.  Print All Nodes");
            System.out.println("4.  Delete Node from Head");
            System.out.println("5.  Delete Node from Tail");
            System.out.println("6.  Delete a Given Node");
            System.out.println("7.  Search for a Node");
            System.out.println("8.  Quit");

            System.out.print("\nSelect an Option [1...8] : ");
            option = stdin.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the element to add at Head: ");
                    list.addToHead(stdin.nextInt());
                    break;

                case 2:
                    System.out.print("Enter the element to add at Tail: ");
                    list.addToTail(stdin.nextInt());
                    break;

                case 3:
                    list.printAll();
                    break;

                case 4:
                    list.deleteFromHead();
                    break;

                case 5:
                    list.deleteFromTail();
                    break;

                case 6:
                    System.out.print("Enter node to delete:  ");
                    target = stdin.nextInt();

                    Integer result = list.delete(target);
                    if (result != null) {
                        System.out.println("The element " + result + " has been deleted");
                    } else {
                        System.out.println("Sorry, element " + target + " is not in the list");
                    }
                    break;

                case 7:
                    System.out.print("Enter node to search for:  ");
                    target = stdin.nextInt();

                    if (list.find(target) != null) {
                        System.out.println("The element " + target + " is in the list");
                    } else {
                        System.out.println("Sorry, element " + target + " is not in the list");
                    }
                    break;

            } //end of switch

        } while (option != 8);
    } //end of main

}
