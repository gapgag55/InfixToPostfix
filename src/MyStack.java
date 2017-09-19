import java.lang.String;

public class MyStack {

    private String[] stack = new String[10];
    private int lastPos = -1;

    public void push(String c) {
        lastPos += 1;
        this.stack[lastPos] = c;
    }

    public void pop() {
        lastPos -= 1;
    }

    public String peek() {
        return (lastPos > -1) ? this.stack[lastPos] : "";
    }

    // HELPER FUNCTION
    public String getLast() {
        StringBuilder operator = new StringBuilder();
        for (int i = lastPos; i >= 0; i--) {
            operator.append( this.stack[i] );
        }
        return operator.toString();
    }

    // HELPER FUNCTION
    public String addToStack(String x) {
        StringBuilder operator = new StringBuilder();
        boolean conOne, conTwo, conThr, conFor;

        while ((lastPos + 1) >= 0) {

            // UPDATE STACK EVERY CHANGED.
            conOne = (this.peek().equals("+") && x.equals("+")) || (this.peek().equals("-") && x.equals("+")) || (this.peek().equals("x") && x.equals("+")) || (this.peek().equals("/") && x.equals("+")) || (this.peek().equals("^") && x.equals("+"));
            conTwo = (this.peek().equals("+") && x.equals("-")) || (this.peek().equals("-") && x.equals("-")) || (this.peek().equals("x") && x.equals("-")) || (this.peek().equals("/") && x.equals("-")) || (this.peek().equals("^") && x.equals("-"));
            conThr = (this.peek().equals("^") && x.equals("x")) || (this.peek().equals("/") && x.equals("x")) || (this.peek().equals("x") && x.equals("x"));
            conFor = (this.peek().equals("^") && x.equals("/")) || (this.peek().equals("/") && x.equals("/")) || (this.peek().equals("x") && x.equals("/"));

            if ( conOne || conTwo || conThr || conFor )
            {
                operator.append(this.peek());
                this.pop();
            }
            else if ( x.equals(")") )
            {
                if ( this.peek().equals("(") )
                {
                    this.pop();
                    break;
                }

                operator.append( this.peek() );
                this.pop();
            }
            else
            {
                this.push(x);
                break;
            }
        }

        return operator.toString();
    }

}
