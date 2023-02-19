
import java.util.Scanner;

public class TestStudentDLL1 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DLL<Student> list = new DLL<Student>();

        String name;
        double gpa;
        int option, id = 0;

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
            option = reader.nextInt();

            switch (option) {
                case 1:

                    System.out.println("Enter Student name:");
                    name = reader.next();

                    System.out.println("Enter Student gpa:");
                    gpa = reader.nextDouble();

                    System.out.println("Enter Student ID:");
                    id = reader.nextInt();
                    list.addToHead(new Student(id, name, gpa));
                    break;

                case 2:

                    System.out.println("Enter Student name:");
                    name = reader.next();

                    System.out.println("Enter Student gpa:");
                    gpa = reader.nextDouble();

                    System.out.println("Enter Student ID:");
                    id = reader.nextInt();
                    list.addToTail(new Student(id, name, gpa));
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
                    Student result = list.delete(new Student(id));
                    if (result != null) {
                        System.out.println(result + " has been deleted");
                    } else {
                        System.out.println("Sorry, " + name + " was not found");
                    }
                    break;

                case 7:
                    System.out.println("Enter the name of the Item:");
                    name = reader.next();
                    Student item = list.find(new Student(id));
                    if (item != null) {
                        System.out.println(item + " was found.");
                    } else {
                        System.out.println("Item was not found");
                    }
                    break;

                case 8:
                    list.clear();
                    System.out.println("List Cleared !");

                    break;

                case 9:
                    if (list != null) {
                        System.out.print("First : " + list.getFirst());

                    } else {
                        System.out.print("Null List");
                    }

                    break;

                case 10:

                    if (list != null) {
                        System.out.print("Last : " + list.getLast());

                    } else {
                        System.out.print("Null List");
                    }
                    break;

                case 11:
                    System.out.print("Length :" + list.length());
                    break;

                case 12:
                    System.out.print(list.toString());
                    break;

                case 13:
                    System.out.print("PrintReverse :");
                    list.printReverse();
                    break;

                case 14:
                    System.out.print("index :");
                    int index = reader.nextInt();
                    System.out.println("Element in index [" + index + "], is : " + list.get(index));

                    break;

                case 15:
                    Student Newinfo = new Student(000,"Non",0.0);
                    System.out.print("Index :");
                    int index1 = reader.nextInt();

                    System.out.print("Name:");
                    Newinfo.name = reader.next();

                    System.out.print("GPA:");
                    Newinfo.gpa = reader.nextDouble();

                    System.out.print("ID No.:");
                    Newinfo.id = reader.nextInt();

                    list.insertAt(index1, Newinfo);
                    break;

                case 16:
                    System.out.print("ToArray :" + list.toArray());
                    break;

            }
        } while (option != 17);
    }
}
