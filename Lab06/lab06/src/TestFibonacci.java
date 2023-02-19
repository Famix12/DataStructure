
import java.util.Scanner;

public class TestFibonacci {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter interger n to print first n terms of Fibonacci sequence: ");
        int n = reader.nextInt();
        System.out.print("First n terms of Fibonacci sequence are: ");
        for (int i = 0; i <= n; i++) 
            System.out.print(fib(i) + " ");
        System.out.println();
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) 
            return n;
        else 
            return fib(n - 1) + fib(n - 2);
    }

}
