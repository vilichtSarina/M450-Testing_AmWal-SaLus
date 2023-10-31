package ch.tbz.graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    public void testIsValidInputWithSingleVariable() {
        Validator validator = new Validator("x^2+3x-5");
        assertTrue(validator.isValidInput());
    }

    @Test
    public void testIsValidInputWithMultipleVariables() {
        Validator validator = new Validator("x^2+y-5");
        assertFalse(validator.isValidInput());
    }

    @Test
    public void testGetInput() {
        Validator validator = new Validator("3x+2");
        assertEquals("3x+2", validator.getInput());
    }

    @Test
    public void testSetInput() {
        Validator validator = new Validator("x^2");
        validator.setInput("2x+3");
        assertEquals("2x+3", validator.getInput());
    }

    @Test
    public void testRemoveFunctions() {
        String input = "sin(x) + cos(y) + tan(z)";
        Validator validator = new Validator(input);

        String expectedOutput = "(x) + (y) + (z)";

        assertEquals(expectedOutput, validator.removeFunctions());
    }
}
