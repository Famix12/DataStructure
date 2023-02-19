
import java.util.Scanner;

public class TestPower {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter number x to find power: ");
        double x = reader.nextDouble();
        System.out.print("Enter integer n for power: ");
        int n = reader.nextInt();
        System.out.print(x + " to power " + n + " is: " + power(x, n));
    }

    public static double power(double x, int n) {
        if (n == 0) 
            return 1;
        else 
            return x * power(x, n - 1);
     }
}
