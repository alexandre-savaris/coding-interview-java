import java.util.Stack;

public class EvaluateReversePolishNotation {

    private static int evaluate(String[] tokens) {

        String operators = "+-*/";
        int n1, n2;
        Stack<String> stack = new Stack<String>();

        for(String t: tokens) {
            // It's a number - push it into the stack.
            if(!operators.contains(t)) {
                stack.push(t);
            }
            else {
                // It's an operator - pop two numbers from the stack, operates on them and push the result into the stack.
                n1 = Integer.parseInt(stack.pop());
                n2 = Integer.parseInt(stack.pop());
                switch(t) {
                    case "+":
                        stack.push(String.valueOf(n1 + n2));
                        break;
                    case "-":  // Observe the order of the arguments!
                        stack.push(String.valueOf(n2 - n1));
                        break;
                    case "*":
                        stack.push(String.valueOf(n1 * n2));
                        break;
                    case "/": // Observe the order of the arguments!
                        stack.push(String.valueOf(n2 / n1));
                        break;
                }
            }
        }

        // Pop the last number from the stack (the result).
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {

        String[] tokens = new String[] { "4", "13", "5", "/", "+" };

        System.out.println(evaluate(tokens));
    }
}
