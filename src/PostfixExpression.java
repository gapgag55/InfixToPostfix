import java.lang.Math;

public class PostfixExpression {

    private MyStack stack = new MyStack();
    private Double value = 0.0;
    private Double first = 0.0;
    private Double second = 0.0;

    public double process(StringBuilder instruction) {
        char character;
        for(int i = 0; i < instruction.length(); i++)
        {
            character = instruction.charAt(i);

            // IS NUMBER ?
            if (Character.isDigit(character)) {
                // ADD NUMBERS TO STACK
                stack.push(Character.toString(character));
            } else {

                first  = ( !stack.peek().equals("") ) ? Double.parseDouble( stack.peek() ) : 0; stack.pop();
                second = ( !stack.peek().equals("") ) ? Double.parseDouble( stack.peek() ) : 0; stack.pop();

                if ( character == '+' ) {
                    value = second + first;
                } else  if ( character == '-' ) {
                    value = second - first;
                } else  if ( character == 'x' ) {
                    value = second * first;
                } else  if ( character == '/' ) {
                    value = second / first;
                } else  if ( character == '^' ) {
                   value = Math.pow(second, first);
                }

                stack.push(String.valueOf(value));
            }
        }

       return Double.parseDouble(stack.peek());
    }

}
