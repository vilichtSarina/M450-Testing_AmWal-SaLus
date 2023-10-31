package ch.tbz.graph.interpreter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DoubleStackTest {


    private DoubleStack stack;
    public DoubleStackTest() {
        stack = new DoubleStack();
    }

    @BeforeEach
    public void resetStack(){
        stack = new DoubleStack();
    }

    @Test
    public void addsOnPush_WithValidNewValue() {
        double firstValue = 2.0;
        double secondValue = 3.0;

        stack.push(firstValue);
        stack.push(secondValue);

        assertEquals(stack.pop(), secondValue);
        assertEquals(stack.pop(), firstValue);
    }

    @Test
    public void testPop_WithNonNullStack() {
        double value = 2.0;

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
        int maximumIndex = 9;

        for (int i= 0; i < maximumIndex; i++) {
            stack.push(i);
        }

        assertTrue(stack.isFull());
    }

}
