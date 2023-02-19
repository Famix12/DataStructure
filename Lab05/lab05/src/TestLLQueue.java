
import java.util.Scanner;

public class TestLLQueue {

    public static void main(String[] args) {
        LLQueue<Integer> queue = new LLQueue<Integer>();
        int option;

        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("\n***************************");
            System.out.println("*   Testing Queue  *");
            System.out.println("***************************\n");
            System.out.println("1.  Enqueue an element");
            System.out.println("2.  Dequeue an Element");
            System.out.println("3.  Get Front element");
            System.out.println("4.  Print queue");
            System.out.println("5.  Clear queue");
            System.out.println("6.  Quit");

            System.out.print("\nSelect an Option [1...6] : ");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    queue.enqueue(reader.nextInt());
                    break;

                case 2:
                    if (!queue.isEmpty()) {
                        System.out.println("Front element, " + queue.dequeue() + " has been removed");
                    } else {
                        System.out.println("Sorry, the queue is empty");
                    }
                    break;

                case 3:
                    if (!queue.isEmpty()) {
                        System.out.println("Front element is: " + queue.firstEl());
                    } else {
                        System.out.println("Sorry, the queue is empty");
                    }
                    break;

                case 4:
                    System.out.println(queue);
                    break;

                case 5:
                    queue.clear();
                    break;

            } //end of switch

        } while (option != 6);
    } //end of main
}
