import java.util.Scanner;

public class EvaluateInfix {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Needed Variables
        StringBuilder postfix = new StringBuilder();

        // input Expression
        // Scanner
        Scanner scan = new Scanner(System.in);
        System.out.print("Input: ");
        String instruction = scan.next();
        // String instruction = "7x(2-3)^4x(5+(8-6))/9";
        // String instruction = "3+(9-4)x5^2+1";
        // String instruction = "((3+4)^2)-3x3";
        // String instruction = "(2-2)-2";
        // String instruction = "4+5x2";
        // String instruction = "(6+4)/(3-5)";
        // String instruction = "7-(3+4)*8-(6-2)/5";

        // Add to Stack
        char character;
        for(int i = 0; i < instruction.length(); i++)
        {
            character = instruction.charAt(i);

            // IS NUMBER ?
            if (Character.isDigit(character)) {
                postfix.append( Character.toString(character) );
            } else {

                // ADD OPERATOR TO STACK
                // HELPER FUNCTION - addToStack()
                // Casting character to String before.
                postfix.append( stack.addToStack(Character.toString(character)) );
            }
        }

        // Add last Operation of Stack
        postfix = postfix.append( stack.getLast() );
        System.out.println("Output: " + postfix);


        // Summation value by PostfixExpression Class
        System.out.println("Result: " + (new PostfixExpression() ).process(postfix));

    }
}
