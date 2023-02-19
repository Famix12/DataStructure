
import java.util.Scanner;

public class TestItemSLL {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        SLL<Item> list = new SLL<Item>();

        String name;
        double price;
        int option;

        do {
            System.out.println("\n***************************");
            System.out.println("Testing SLL with Item Objects");
            System.out.println("***************************");
            System.out.println("1.adding a new node to the head");
            System.out.println("2.adding a new node to the tail");
            System.out.println("3.print all nodes ");
            System.out.println("4.delete a node from the head");
            System.out.println("5.delete a node from the tail");
            System.out.println("6.delete a node by its name");
            System.out.println("7.search for a node");
            System.out.println("8.Quit");
 
            System.out.print("\nSelect an Option [1...8] : ");
            option = reader.nextInt();

            switch (option) {
                case 1:

                    System.out.println("Enter item name:");
                    name = reader.next();
                    System.out.println("Enter item price:");
                    price = reader.nextDouble();
                    list.addToHead(new Item(name, price));
                    break;

                case 2:

                    System.out.println("Enter item name:");
                    name = reader.next();
                    System.out.println("Enter item price:");
                    price = reader.nextDouble();
                    list.addToTail(new Item(name, price));
                    break;

                case 3:
                    if (list.isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        list.printAll();
                    }
                    break;

                case 4:
                    list.deleteFromHead();
                    break;

                case 5:
                    list.deleteFromTail();
                    break;

                case 6:
                    System.out.println("Enter the name of the Item to delete:");
                    name = reader.next();
                    Item result = list.delete(new Item(name));
                    if (result != null) {
                        System.out.println(result + " has been deleted");
                    } else {
                        System.out.println("Sorry, " + name + " was not found");
                    }
                    break;

                case 7:
                    System.out.println("Enter the name of the Item:");
                    name = reader.next();
                    Item item = list.find(new Item(name));
                    if (item != null) {
                        System.out.println(item + " was found.");
                    } else {
                        System.out.println("Item was not found");
                    }
                    break;
            }
        } while (option != 8);
    }
}
