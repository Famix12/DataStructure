
import java.util.Scanner;

public class TestPrintOdds {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter interger n to print odd numbers from 1 to n: ");
        int n = reader.nextInt();
        System.out.print("Odd numbers are: ");
        printOdds(n);
        System.out.print("\nOdd numbers in reverse are: ");
        reversePrintOdds(n);
        System.out.println();
    }

    //prints odd numbers from 1...n
    public static void printOdds(int n) {
        if (n == 1) {
            System.out.print(n + " ");
        } else {
            printOdds(n - 1);
            if (n % 2 == 1) // if n is odd
            {
                System.out.print(n + " ");
            }
        }
    }

    //print odd numbers from n...1 (in reverse)
    public static void reversePrintOdds(int n) {
        if (n == 1) {
            System.out.print(n + " ");
        } else {
            if (n % 2 == 1) // if n is odd
            {
                System.out.print(n + " ");
            }
            reversePrintOdds(n - 1);
        }
    }

}
