package ch.tbz.graph.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Tokenizer is a class that is used by the Interpreter to split up te generic String into its (maybe) multi-character components.
 */
public class Tokenizer {

    private String input;
    private List<String> tokens;
    private char variable;
    private StringBuilder maybeFunction = new StringBuilder();

    private StringDeterminer determiner = new StringDeterminer();

    public Tokenizer(String input) {
        String initialInput = input.replaceAll(" ", "");
        this.input = modifyInput(initialInput);
    }

    /**
     *
     * @return the resulting tokens
     */
    public List<String> getTokens() {
        this.variable = findVariable(input);
        this.tokens = createTokens(new ArrayList<>());

        return tokens;
    }

    /**
     *
     * @param in unmodified input
     * @return input that has every multiplication character where applicable
     */
    private String modifyInput(String in) {
        if (variable == '\0') {
            return in;
        }
        char lastChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (determiner.isNumerical(lastChar)
            && input.charAt(i) == variable) {
                String prefix = input.substring(0, i);
                String postfix = input.substring(i);
                modifyInput(prefix + "*" + postfix);
            }
        }
        return in;
    }

    /**
     *
     * @param tokens empty list to start ith
     * @return resulting tokens
     */
    private List<String> createTokens(List<String> tokens) {
        this.tokens = tokens;
        char lastCharacter = input.charAt(0);
        int tokenStartIndex = 0;
        boolean isMinusForNegativeValue = handleInitialCharacterAction(lastCharacter);

        if(input.length() == 1) {
            input = input + " ";
        }

        for (int i = 1; i < input.length(); i++) {
            boolean alreadyAddedNumber = false;
            char currentCharacter = input.charAt(i);

            handleFunctionTokenization(lastCharacter, currentCharacter);

            if (isNegativeNumber(i, lastCharacter, currentCharacter, isMinusForNegativeValue)
                    || isValidNumberStart(lastCharacter, currentCharacter, isMinusForNegativeValue)) {
                tokenStartIndex = i;
            }

            //Handle negative numbers / variables
            if (isNegativeNumber(i, lastCharacter, currentCharacter, isMinusForNegativeValue)) {
                isMinusForNegativeValue = true;
            } else if (isNegativeVariable(i, lastCharacter, currentCharacter, isMinusForNegativeValue)) {
                tokens.add(String.valueOf(currentCharacter) + input.charAt(i + 1));

                i = i + 1;
                lastCharacter = variable;
                continue;
            }

            handleVariableTokenization(lastCharacter, currentCharacter);
            isMinusForNegativeValue = handleNumberTokenization(i, currentCharacter, tokenStartIndex, isMinusForNegativeValue, alreadyAddedNumber);
            handleOperatorTokenization(currentCharacter, isMinusForNegativeValue);

            lastCharacter = currentCharacter;
        }

        return tokens;
    }

    /**
     *
     * @param input unmodified input to search through
     * @return the variable char that is found
     */
    private char findVariable(String input) {
        String inputCopy = input;
        for (String function : determiner.getFunctions()) {
            inputCopy = inputCopy.replaceAll(function, "");
        }
        for (int i = 0; i < inputCopy.length(); i++) {
            if (determiner.isAlphabetical(inputCopy.charAt(i))) {
                return inputCopy.charAt(i);
            }
        }
        return '\0';
    }

    /**
     *
     * @param lastCharacter
     * @return true if the character is a negative number, false if not
     */
    private boolean handleInitialCharacterAction(char lastCharacter) {
        if (lastCharacter == variable) {
            tokens.add(String.valueOf(variable));
        } else if (determiner.isAlphabetical(lastCharacter)) {
            maybeFunction.append(lastCharacter);
        } else if (input.length() > 1 && determiner.isNumerical(lastCharacter)
                && !determiner.isNumerical(input.charAt(1))) {
            tokens.add(String.valueOf(lastCharacter));
        } else if (input.length() > 1 && lastCharacter == '-'
                && (determiner.isNumerical(input.charAt(1))
                || input.charAt(1) == '-')) {
            return true;
        }
        return false;
    }

    /**
     * Creates a function by appending it to a StringBuilder maybeFunction
     * @param lastCharacter
     * @param currentCharacter
     */
    private void handleFunctionTokenization(char lastCharacter, char currentCharacter) {
        if (determiner.isAlphabetical(lastCharacter) && determiner.isAlphabetical(currentCharacter)) {
            // In case the last character was a char, append to string to check whether this is a function
            maybeFunction.append(currentCharacter);
        } else if (determiner.isFunction(maybeFunction.toString()) && determiner.isSeparator(currentCharacter)) {
            // When maybeFunction is a string, tokenize it, reset maybeFunction afterwards
            tokens.add(maybeFunction.toString());
            maybeFunction = new StringBuilder();
        } else if (determiner.isSeparator(currentCharacter)) {
            tokens.add(String.valueOf(currentCharacter));
        }
    }

    /**
     * Creates tokens applying rules specifically with variables
     * @param lastCharacter
     * @param currentCharacter
     */
    private void handleVariableTokenization(char lastCharacter, char currentCharacter) {
        if ((determiner.isOperator(lastCharacter) || determiner.isSeparator(lastCharacter)) && currentCharacter == variable) {
            tokens.add(String.valueOf(variable));
        } else if (variable != '\0' && determiner.isNumerical(lastCharacter) && currentCharacter == variable) {
            //in case a multiplier is in front of the non-null variable, insert an asterisk and the variable
            tokens.add("*");
            tokens.add(String.valueOf(variable));
        }
    }

    /**
     * tokenizes numbers
     * @param i current iteration index
     * @param currentCharacter
     * @param tokenStartIndex starting index of current token
     * @param isMinusForNegativeValue whether number is negative
     * @param alreadyAddedNumber whether number was already added to tokens
     * @return isMinusForNegativeValue
     */
    private boolean handleNumberTokenization(int i, char currentCharacter, int tokenStartIndex,
                                          boolean isMinusForNegativeValue, boolean alreadyAddedNumber) {
        if ((i == input.length() - 1 || !determiner.isNumerical(input.charAt(i + 1))) && determiner.isNumerical(currentCharacter)) {
            // As soon as there isn't a number anymore, we know that the tokenEndIndex is i-1
            tokens.add(input.substring(tokenStartIndex, i + 1));
            isMinusForNegativeValue = false;
            alreadyAddedNumber = true;
        }

        if (determiner.isNumerical(currentCharacter) && i == input.length() - 1 && !alreadyAddedNumber) {
            tokens.add(input.substring(tokenStartIndex));
        }
        return isMinusForNegativeValue;
    }

    /**
     * tokenizes operators
     * @param currentCharacter
     * @param isMinusForNegativeValue wether number is negative
     */
    private void handleOperatorTokenization(char currentCharacter, boolean isMinusForNegativeValue) {
        if (determiner.isOperator(currentCharacter) && !isMinusForNegativeValue) {
            tokens.add(String.valueOf(currentCharacter));
        }
    }

    /**
     *
     * @param lastCharacter
     * @param currentCharacter
     * @param isMinusForNegativeValue whether current number is negative
     * @return
     */
    private boolean isValidNumberStart(char lastCharacter, char currentCharacter, boolean isMinusForNegativeValue) {
        return !determiner.isNumerical(lastCharacter) && determiner.isNumerical(currentCharacter) && !isMinusForNegativeValue;
    }

    /**
     *
     * @param i iteration index
     * @param lastCharacter
     * @param currentCharacter
     * @param isMinusForNegativeValue whether current number is negative
     * @return
     */
    private boolean isNegativeVariable(int i, char lastCharacter, char currentCharacter, boolean isMinusForNegativeValue) {
        return ((determiner.isSeparator(lastCharacter) || determiner.isOperator(lastCharacter))
                && (currentCharacter == '-' || i == 1)
                && !isMinusForNegativeValue) && i != input.length() - 1 && input.charAt(i + 1) == variable;
    }

    /**
     *
     * @param i iteration index
     * @param lastCharacter
     * @param currentCharacter
     * @param isMinusForNegativeValue whether current number is negative
     * @return
     */
    private boolean isNegativeNumber(int i, char lastCharacter, char currentCharacter, boolean isMinusForNegativeValue) {
        return ((determiner.isSeparator(lastCharacter) || determiner.isOperator(lastCharacter))
                && (currentCharacter == '-' || i == 1)
                && !isMinusForNegativeValue) && i != input.length() - 1 && determiner.isNumerical(input.charAt(i + 1));
    }

    /**
     *
     * @return the found variable
     */
    public char getVariable() {
        return variable;
    }

}
