package ch.tbz.exception;

public class FunctionFormatException extends NumberFormatException{
    public FunctionFormatException(String functionInput) {
        super("The input \"" + functionInput + "\" doesn't follow the requirements.");
    }
}
