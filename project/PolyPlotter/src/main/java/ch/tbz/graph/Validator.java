package ch.tbz.graph;

import ch.tbz.graph.interpreter.StringDeterminer;

import java.util.List;
import java.util.Locale;

/**
 * Class used for custom graph display to check, whether an input even could be considered a mathematical expression.
 */
public class Validator {

    private String input;

    public Validator(String input) {
        this.input = input;
    }

    /**
     *
     * @return true if the generic string is a valid input
     */
    public boolean isValidInput() {
        if (!containsSingleVariable()) {
            return false;
        }

        return true;
    }

    /**
     *
     * @return true if no more than 1 variable is in the function.
     */
    private boolean containsSingleVariable() {
        String[] splitInputs = removeFunctions().split("(?!^)");
        String variable = "";
        for (String splitInput : splitInputs) {
            if ("".equals(variable) && splitInput.matches("[a-zA-Z]+")) {
                variable = splitInput;
            }
            if (!"".equals(variable) && splitInput.matches("[a-zA-Z]+") && !(splitInput.equals(variable))) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return  input string without functions
     */
    String removeFunctions() {
        String modInput = input;
        for (String function : new StringDeterminer().getFunctions()) {
            modInput = modInput.toLowerCase(Locale.ROOT).replaceAll(function, "");
        }
        return modInput;
    }

    /**
     *
     * @return generic input
     */
    public String getInput() {
        return input;
    }

    /**
     *
     * @param input to be set
     */
    public void setInput(String input) {
        this.input = input.toLowerCase(Locale.ROOT);
    }
}
