import java.util.Scanner;

public class TestFactorial {
        
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter interger n to find its factorial: ");
        int n=reader.nextInt();
        System.out.println("Factorial of "+n+" is: "+factorial(n));
    }
    
    public static int factorial (int n)  {
       if (n == 0)
          return 1;
       else 
         return n*factorial(n-1);
    }
    
}
