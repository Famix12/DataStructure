
import java.util.Scanner;

public class TestPrintTo {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter interger n to print [1...n]: ");
        int n = reader.nextInt();
        printTo(n);
        
        System.out.println("\nThe numbers in reverse are:");
        reversePrintTo(n);
    }

    public static void printTo(int n) {
        if (n == 0)
           System.out.println(n);
        else {
           printTo(n-1);
           System.out.println(n);
        }
    }
    
    public static void reversePrintTo(int n) {
        if (n == 0) 
            System.out.println(n);
        else {
            System.out.println(n);
            reversePrintTo(n - 1);
        }
    }

}
