package ch.tbz.graph.interpreter;

public class StringStack {

    private String[] strings = new String[9];
    private int index = -1;


    /**
     * Inserts a value on top of the stack
     * @param string
     */
    public void push(String string) {
        if (!isFull()) {
            strings[++index] = string;
        }
    }

    /**
     * Basic stack structure functionality takes and eliminates the last inserted element.
     * @return to be removed from the stack
     */
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        return strings[index--];
    }

    /**
     * @return the value of the most recently inserted value without eliminating it.
     */
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return strings[index];
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
        return index == strings.length-1;
    }
}
