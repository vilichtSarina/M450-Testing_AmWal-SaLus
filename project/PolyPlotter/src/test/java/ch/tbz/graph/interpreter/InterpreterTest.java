package ch.tbz.graph.interpreter;

import ch.tbz.exception.ParenthesesMismatchException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InterpreterTest {

    private static Interpreter interpreter;

    @BeforeAll
    public static void init() {
        interpreter = new Interpreter();
    }

    @Test
    public void testConvertToReversePolishNotation_WithValidInput_WillInterpret() {
        String input = "3+4";
        assertEquals(interpreter.convertToReversePolishNotation(input), List.of("3", "4", "+"));
    }

    @Test
    public void testConvertToReversePolishNotation_WithInvalidParentheses_ThrowsException() {
        String input = "2+3(1-2";
        Exception expection = assertThrows(ParenthesesMismatchException.class, () ->
                interpreter.convertToReversePolishNotation(input));
        assertEquals("The input \"2+3(1-2\" doesn't follow the requirements.", expection.getMessage());
    }
}
