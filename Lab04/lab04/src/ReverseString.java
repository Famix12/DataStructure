
import java.util.Scanner;

class ReverseString {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the string to reverse: ");
        String s = reader.nextLine();
        System.out.println("The string reversed is: " + reverse(s));
    }
    
    public static String reverse(String s) {
        LLStack<Character> stack = new LLStack<Character>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += stack.pop();
        }

        return result;
    }
}
