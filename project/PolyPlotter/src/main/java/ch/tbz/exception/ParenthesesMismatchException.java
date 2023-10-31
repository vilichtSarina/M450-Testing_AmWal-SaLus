package ch.tbz.exception;

/**
 * This exception occurs during interpreting, when a parentheses mismatch has been detected, i.e.
 * not the same amount of opening / closing parentheses was given.
 */
public class ParenthesesMismatchException extends FunctionFormatException{
    public ParenthesesMismatchException(String functionInput) {
        super(functionInput);
        System.out.println("The given function had a parentheses mismatch, is therefore not processable.");
    }
}
