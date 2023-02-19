
import java.util.Scanner;

public class TestDelimiterMatching {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the string to check for matching brackts: ");
        String s = reader.nextLine();

        if (delimiterMatching(s)) {
            System.out.println("The brackets are matching");
        } else {
            System.out.println("The brackets are not matching");
        }
    }

    //checks if an expression contains matching brackets (), [] or {}
    public static boolean delimiterMatching(String s) {
        LLStack<Character> stack = new LLStack<Character>();

        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') //opening bracket
            {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') { //closing bracket
                if (stack.isEmpty()) {
                    return false;
                } else if (!matchingBrackets(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean matchingBrackets(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')')
                || (ch1 == '[' && ch2 == ']')
                || (ch1 == '{' && ch2 == '}');
    }
}
