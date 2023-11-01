package ch.tbz.graph.interpreter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringDeterminerTest {

    private static StringDeterminer helper;

    @BeforeAll
    public static void init() {
        helper = new StringDeterminer();
    }

    @Test
    public void testIsFunction_WithValidFunction() {
        assertTrue(helper.isFunction("sin"));
    }

    @Test
    public void testIsSeparator_WithParenthesis() {
        assertTrue(helper.isSeparator('('));
    }

    @Test
    public void testIsNumerical_WhenNonNumericalValue() {
        assertFalse(helper.isNumerical('q'));
    }

    @Test
    public void testIsOperator_WithInvalidCharacter() {
        assertFalse(helper.isOperator("%"));
    }
}
