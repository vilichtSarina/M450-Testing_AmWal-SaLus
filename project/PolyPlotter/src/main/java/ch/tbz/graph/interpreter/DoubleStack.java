package ch.tbz.graph.interpreter;

/**
 * This stack data structure takes doubles.
 */
public class DoubleStack {

    private double[] numbers = new double[9];
    private int index = -1;


    /**
     * Inserts a value on top of the stack
     * @param number
     */
    public void push(double number) {
        if (!isFull()) {
            numbers[++index] = number;
        }
    }

    /**
     * Basic stack structure functionality takes and eliminates the last inserted element.
     */
    public double pop() {
        if (isEmpty()) {
            return 0;
        }
        return numbers[index--];
    }

    /**
     * Helper function to determine whether the stack is empty.
     * @return
     */
    public boolean isEmpty() {
        return index == -1;
    }

    /**
     * Helper function to determine whether the stack is full.
     * @return
     */
    public boolean isFull() {
        return index == numbers.length-1;
    }
}
