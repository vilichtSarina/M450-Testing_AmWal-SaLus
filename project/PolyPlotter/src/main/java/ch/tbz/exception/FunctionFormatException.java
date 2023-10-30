package ch.tbz.exception;

/**
 * This exception occurs during interpreting.
 * It's extended by the more specific ParenthesesMismatchException.
 * 
 * As a general idea, this class has the purpose of surfacing the exception whenever a given input in the
 * GraphInputMenu cannot be converted into a valid mathematical function and or graph.*/
public class FunctionFormatException extends NumberFormatException{
    public FunctionFormatException(String functionInput) {
        super("The input \"" + functionInput + "\" doesn't follow the requirements.");
    }
}
