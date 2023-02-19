
import java.util.Scanner;

class AddLargeIntegers {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        String s1 = reader.next();
        System.out.print("Enter the second integer: ");
        String s2 = reader.next();

        System.out.println("The sum of the two integers is: " + add(s1, s2));
    }

    public static String add(String n1, String n2) {
        LLStack<Integer> stack1 = new LLStack<Integer>();
        LLStack<Integer> stack2 = new LLStack<Integer>();
        LLStack<Integer> stack3 = new LLStack<Integer>();

        int n;
        for (int i = 0; i < n1.length(); i++) {
            n = Character.getNumericValue(n1.charAt(i)); //converts character to digit
            //or  n = Integer.parseInt(""+n1.charAt(i));
            stack1.push(n);
        }

        for (int i = 0; i < n2.length(); i++) {
            n = Character.getNumericValue(n2.charAt(i)); //converts character to digit
            stack2.push(n);
        }

        int result = 0, ns1 = 0, ns2 = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            if (!stack1.isEmpty()) {
                ns1 = stack1.pop();
            }
            //ns1 = ((Integer) stack1.pop()).intValue();

            if (!stack2.isEmpty()) {
                ns2 = stack2.pop();
            }
            //ns2 = ((Integer) stack2.pop()).intValue();

            result = result + ns1 + ns2;

            stack3.push(result % 10);
            result = result / 10;

            ns1 = ns2 = 0;
        }

        if (result != 0) {
            stack3.push(result);
        }

        String ans = "";
        while (!stack3.isEmpty()) {
            ans += stack3.pop();
        }

        return ans;
    }
}
