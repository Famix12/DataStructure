
import java.util.Scanner;

public class TestDoubleDLL1 {

    public static void main(String[] args) {
        DLL<Double> list = new DLL<Double>();
        int option;
        double target;

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
            System.out.println("8.  Clear");
            System.out.println("9.  Get first ");
            System.out.println("10. Get last ");
            System.out.println("11. List length ");
            System.out.println("12. toString");
            System.out.println("13. PrintReverse");
            System.out.println("14. Get Node by index");
            System.out.println("15. Insert value At index");
            System.out.println("16. Return all elements as an Array");
            System.out.println("17. Quit");

            System.out.print("\nSelect an Option [1...17] : ");
            option = stdin.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the element to add at Head: ");
                    list.addToHead(stdin.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter the element to add at Tail: ");
                    list.addToTail(stdin.nextDouble());
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
                    target = stdin.nextDouble();

                    Double result = list.delete(target);

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

                case 8:
                    list.clear();
                    System.out.println("List Cleared");
                    break;

                case 9:
                    System.out.println("First :" + list.getFirst());
                    break;

                case 10:
                    System.out.println("Last :" + list.getLast());
                    break;

                case 11:
                    System.out.println("length :" + list.length());
                    break;

                case 12:
                    System.out.println("toString :" + list.toString());
                    break;

                case 13:
                    System.out.print("PrintReverse :    ");
                    list.printReverse();
                    break;
                    
                case 14:
                    System.out.print("index :");
                    int index = stdin.nextInt();
                    System.out.println("Element in index ["+ index +"], is : " + list.get(index));
                    
                    break;
                    
                case 15:
                    System.out.print("Index :");
                    int index1 = stdin.nextInt();
                    System.out.print("Value :");
                    double value = stdin.nextInt();

                    list.insertAt(index1, value);
                    break;
                    
                case 16:
                    System.out.print("ToArray :"+list.toArray());
                    break;


            } //end of switch

        } while (option != 17);
    } //end of main

}
