package part1;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by visenger on 19.06.17.
 */
public class ExpressionEvaluator {

    public static void main(String... args) {
        String expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";

        double result = eval(expression);

        System.out.println("evaluated expression = " + result);
    }

    private static double eval(String expression) {

        //"( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"
        //"( 1 + ( ( 5 ) * ( 4 * 5 ) ) )"
        //"( 1 + ( ( 5 ) * ( 20 ) ) )"
        //"( 1 + ( 100 ) )"
        //"( 101 )"

        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        Scanner scanner = new Scanner(expression);

        while (scanner.hasNext()) {
            String token = scanner.next();

            if (token.equals("(")) {

            } else if (isOperator(token)) {
                ops.push(token);
            } else if (token.equals(")")) {

                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                if (op.equals("*")) vals.push(vals.pop() * vals.pop());

            } else {
                vals.push(Double.valueOf(token));
            }

        }

        return vals.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/");
    }
}
