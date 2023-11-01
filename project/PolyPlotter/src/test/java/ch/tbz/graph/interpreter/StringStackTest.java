package ch.tbz.graph.interpreter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringStackTest {

    private static StringStack stack;

    @BeforeAll
    public static void init() {
        stack = new StringStack();
    }

    @BeforeEach
    public void resetStack() {
        stack = new StringStack();
    }

    @Test
    public void addsOnPush_WithValidNewValue() {
        String firstValue = "first";
        String secondValue = "second";

        stack.push(firstValue);
        stack.push(secondValue);

        assertEquals(stack.pop(), secondValue);
        assertEquals(stack.pop(), firstValue);
    }

    @Test
    public void testPop_WithNonNullStack() {
        String value = "someValue";
        stack.push(value);

        assertEquals(stack.pop(), value);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty_WithEmptyStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull_WithNonNullStack() {
        String value = "someValue";
        int maximumIndex = 9;
        for (int i = 0; i < maximumIndex; i++) {
            stack.push(value);
        }
        assertTrue(stack.isFull());
    }
}
