
import java.util.Scanner;

class TestPalindrome {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a word to check : ");
        String word = reader.next();
        System.out.println(isPalindrome(word));

//        System.out.print("Enter the string to reverse: ");
//        String s = reader.nextLine();
//        System.out.println("The string reversed is: " + reverse(s));
    }

    public static String reverse(String s) {
        DLLStack<Character> stack = new DLLStack<Character>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += stack.pop();
        }

        return result;
    }

    public static boolean isPalindrome(String s) {
        int l = s.length() - 1;
        DLLStack<Character> stack = new DLLStack<Character>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }//""

        char RevC;

        for (int i = 0; i < s.length(); i++) {
            RevC = stack.pop();
            if (RevC != s.charAt(i)) {
                return false;
            }
        }
        return true;

    }// "10" 10 
}
