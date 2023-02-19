
import java.util.Scanner;
import java.util.Iterator;

public class TestItemDLL {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        DLL<Item> list = new DLL<Item>();

        String name;
        double price, max;
        Object found;
        int option;

        do {
            System.out.println("\n***************************");
            System.out.println("   Testing Item DLL  ");
            System.out.println("***************************");
            System.out.println("1.adding a new node to the head");
            System.out.println("2.adding a new node to the tail");
            System.out.println("3.print all nodes ");
            System.out.println("4.delete a node from the head");
            System.out.println("5.delete a node from the tail");
            System.out.println("6.delete a node by its name");
            System.out.println("7.search for a node");
            System.out.println("8.print items whose price is more than a given limit");
            System.out.println("9.Quit");

            System.out.print("\nSelect an Option [1...9] : ");
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
                    list.printAll();
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
                    found = list.find(new Item(name));
                    if (found != null) {
                        list.delete(new Item(name));
                        System.out.println(found + " has been deleted");
                    } else {
                        System.out.println("Sorry, " + name + " was not found");
                    }

                    break;

                case 7:
                    System.out.println("Enter the name of the Item to search:");
                    name = reader.next();
                    found = list.find(new Item(name));
                    if (found != null) {
                        System.out.println(found + " was found");
                    } else {
                        System.out.println("Sorry, " + name + " was not found");
                    }
                    break;

                case 8:
                    System.out.print("Enter the limit price to print greater than it:");
                    max = reader.nextDouble();
                    printGreaterThan(max, list);
                    break;
            }
        } while (option != 9);
    }

    public static void printGreaterThan(double limit, DLL<Item> list) {
        for (Item item : list) {
            if (item.price > limit) {
                System.out.println(item);
            }
        }
    }

    public static void printGreaterThan2(double limit, DLL<Item> list) {
        Iterator<Item> it = list.iterator();
        Item item;
        while (it.hasNext()) {
            item = it.next();
            if (item.price > limit) {
                System.out.println(item);
            }
        }
    }
    
    public static double totalCost(String itemName, int quantity, DLL<Item> list){
        double price = 0;
        
        for(Item item : list){
           if(item.name == itemName){
               price = item.price;
           }
        }
        return price*quantity;
    }
}
