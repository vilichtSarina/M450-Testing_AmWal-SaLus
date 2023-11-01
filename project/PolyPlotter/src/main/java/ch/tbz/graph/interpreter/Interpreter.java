package ch.tbz.graph.interpreter;

import ch.tbz.exception.ParenthesesMismatchException;
import ch.tbz.graph.calculation.GraphPixelCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Implements the Interpreter pattern and converts a generic String into a mathematical expression.
 */
public class Interpreter {

    private final StringDeterminer determiner = new StringDeterminer();
    private final HashMap<String, Integer> operatorPrecedence = new HashMap<>() {{
        put("+", 2);
        put("-", 2);
        put("*", 3);
        put("/", 3);
        put("^", 4);
    }};

    private final String operations = "+-*/()^";
    private String variable;

    /**
     * Takes a generic string and applies the sunting yard algorithm to it.
     *
     * @param input generic input string
     * @return list of tokens, ordered with postfix notation
     * @throws ParenthesesMismatchException
     */
    public List<String> convertToReversePolishNotation(String input) throws ParenthesesMismatchException {
        StringStack stack = new StringStack();
        Tokenizer tokenizer = new Tokenizer(input);
        List<String> tokens = tokenizer.getTokens();
        this.variable = String.valueOf(tokenizer.getVariable());

        List<String> output = new ArrayList<>();

        for (int i = 0; i < tokens.size(); ++i) {
            String c = tokens.get(i);

            if (c.equals(variable) || determiner.isNumerical(c)) {
                output.add(c);
            } else if (determiner.isFunction(c)) {
                stack.push(c);
            } else if (determiner.isOpeningParenthesis(c)) {
                stack.push(c);
            } else if (determiner.isClosingParenthesis(c)) {
                while (!stack.isEmpty()
                        && !determiner.isOpeningParenthesis(stack.peek())) {
                    output.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && getPrecedence(c)
                        <= getPrecedence(stack.peek())
                        && hasLeftAssociativity(c)) {
                    output.add(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (determiner.isOpeningParenthesis(stack.peek())) {
                StringBuilder initialfunction = new StringBuilder();
                for (String token : tokens) {
                    initialfunction.append(token);
                }
                throw new ParenthesesMismatchException(initialfunction.toString());
            }
            output.add(stack.pop());
        }
        return output;
    }

    /**
     * Provides the y coordinate for a given x coordinate
     *
     * @param x      current x coordinate
     * @param xMin   minimum x coordinate to be rendered
     * @param tokens post fix ordered tokens
     * @return resulting y coordinate
     */
    public double getYForParsedInput(double x, double xMin, List<String> tokens) {
        DoubleStack operands = new DoubleStack();

        double first = 0.0;
        double second = 0.0;

        for (String token : tokens) {
            if (!determiner.isOperator(token) && !determiner.isFunction(token)) {
                operands.push(getTokenValue(x, xMin, token));
            } else if (!determiner.isFunction(token)) {
                second = operands.pop();
                first = operands.pop();

                switch (token) {
                    case "+" -> first = first + second;
                    case "-" -> first = first - second;
                    case "*" -> first = first * second;
                    case "/" -> first = first / second;
                    case "^" -> first = Math.pow(first, second);
                }

                operands.push(first);
            } else {
                first = operands.pop();

                switch (token) {
                    case "sin" -> first = Math.sin(first);
                    case "cos" -> first = Math.cos(first);
                    case "tan" -> first = Math.tan(first);
                    case "arcsin" -> first = Math.asin(first);
                    case "arccos" -> first = Math.acos(first);
                    case "arctan" -> first = Math.atan(first);
                    case "sqrt" -> first = Math.sqrt(first);
                    case "log" -> first = Math.log(first);
                    case "exp" -> first = Math.exp(first);
                }
                operands.push(first);
            }
        }

        return operands.pop();
    }

    /**
     * converts the string token to its corresponding double value
     *
     * @param x     x coordinate
     * @param xMin  minimum x coordinate to be rendered
     * @param token to be converted
     * @return double value of token
     */
    private double getTokenValue(double x, double xMin, String token) {
        if (token.equals(variable)) {
            return GraphPixelCalculator.getX();
        }
        if (token.equals(String.valueOf(xMin))) {
            return x;
        }
        return Double.parseDouble(token);
    }

    /**
     * Implementation of the grammar for the interpreter pattern, which returns the precedence of different operations.
     *
     * @param o1 operator
     * @return its precedence value
     */
    private int getPrecedence(String o1) {
        if (operatorPrecedence.get(o1) == null) {
            return -1;
        } else {
            return operatorPrecedence.get(o1);
        }
    }

    /**
     * Helper function to determine whether left assiciativity should be considered
     *
     * @param token
     * @return true / false
     */
    private boolean hasLeftAssociativity(String token) {
        return Objects.equals(token, "+") || Objects.equals(token, "-")
                || Objects.equals(token, "/") || Objects.equals(token, "*");
    }
}
