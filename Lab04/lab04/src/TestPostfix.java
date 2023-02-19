
import java.util.Scanner;

class TestPostfix {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the Postfix expression : ");
        String s = reader.nextLine();

        System.out.println("Result = " + evaluate(s));

    }

    public static int evaluate(String postfix) {
        DLLStack<Integer> stack = new DLLStack<Integer>();
        int i =0;
        while (!postfix.isEmpty()) {
            if(Character.isDigit(postfix.charAt(i))){
                stack.push(Character.getNumericValue(postfix.charAt(i)));
            }else if(IsOpt(postfix.charAt(i))){
                char OP = postfix.charAt(i);
                
                switch (OP) {
                    case '/':
                        
                        break;
                    default:
                        throw new AssertionError();
                }
            }

        }
        return 1;
    }

    public static boolean IsOpt(char op) {
        if (op == '/' || op == '+' || op == '*' || op == '-' || op == '%') {
            return true;
        }
        return false;
    }
}
