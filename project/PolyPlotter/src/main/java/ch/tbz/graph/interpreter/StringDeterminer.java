package ch.tbz.graph.calculation.interpreter;

import java.util.List;

/**
 * Shared helper class that has all the necessary functions to determine the different checks for interpreting.
 */
public class StringDeterminer {

    private final List<String> functions = List.of("sin", "cos", "tan", "arcsin", "arccos", "arctan", "sqrt", "log", "exp");

    /**
     *
     * @param token token to be tested
     * @return true if token is a function
     */
    public boolean isFunction(String token) {
        return functions.stream().anyMatch(function -> (function).equals(token));
    }

    /**
     *
     * @param character
     * @return true ich char is a parenthesis
     */
    public boolean isSeparator(char character) {
        return character == '(' || character == ')';
    }

    /**
     *
     * @param character
     * @return true is char is a number
     */
    public boolean isNumerical(char character) {
        return Character.isDigit(character) || character == '.';
    }

    /**
     *
     * @param character
     * @return true if char is an operator
     */
    public boolean isOperator(char character) {
        return (character == '/' || character == '*' || character == '-' || character == '+' || character == '^');
    }

    /**
     *
     * @param character
     * @return true if char is alphabetical
     */
    public boolean isAlphabetical(char character) {
        return Character.isAlphabetic(character);
    }

    /**
     *
     * @param token
     * @return true if string is opening parenthesis
     */
    public boolean isOpeningParenthesis(String token) {
        return token.equals("(");
    }

    /**
     *
     * @param token
     * @return true if string is closing parenthesis
     */
    public boolean isClosingParenthesis(String token) {
        return token.equals(")");
    }

    /**
     *
     * @param token
     * @return true if string is numerical
     */
    public boolean isNumerical(String token) {
        return token.matches("\\d");
    }

    /**
     *
     * @param token
     * @return true if string is operator
     */
    public boolean isOperator(String token) {
        return token.equals("/") || token.equals("*") || token.equals("-") || token.equals("+") || token.equals("^") ;
    }

    /**
     *
     * @return all possible functions
     */
    public List<String> getFunctions() {
        return functions;
    }
}
