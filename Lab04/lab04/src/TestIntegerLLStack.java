
import java.util.Scanner;

public class TestIntegerLLStack {

    public static void main(String[] args) {
        DLLStack<Integer> stack = new DLLStack<Integer>();
        int option;

        Scanner stdin = new Scanner(System.in);

        do {
            System.out.println("\n***************************");
            System.out.println("*   Testing Integer LLStack  *");
            System.out.println("***************************\n");
            System.out.println("1.  Push an element");
            System.out.println("2.  Pop an Element");
            System.out.println("3.  Get top element");
            System.out.println("4.  Print stack");
            System.out.println("5.  Clear stack");
            System.out.println("6.  Quit");

            System.out.print("\nSelect an Option [1...6] : ");
            option = stdin.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    stack.push(stdin.nextInt());
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("Top element, " + stack.pop() + " has been removed");
                    } else {
                        System.out.println("Sorry, the stack is empty");
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Top element is: " + stack.topEl());
                    } else {
                        System.out.println("Sorry, the stack is empty");
                    }
                    break;

                case 4:
                    System.out.println(stack);
                    break;

                case 5:
                    stack.clear();
                    break;

            } //end of switch

        } while (option != 6);
    } //end of main
}
