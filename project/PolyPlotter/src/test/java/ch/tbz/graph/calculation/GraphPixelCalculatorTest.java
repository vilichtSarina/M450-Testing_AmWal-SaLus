package ch.tbz.graph.calculation;

import ch.tbz.exception.ParenthesesMismatchException;
import ch.tbz.graph.calculation.GraphPixelCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GraphPixelCalculatorTest {

    @Test
    public void testCalcGraph() throws ParenthesesMismatchException {
        String input = "test input";
        int stdWidth = 800;
        int stdHeight = 800;

        GraphPixelCalculator calculator = new GraphPixelCalculator(input, stdWidth, stdHeight);
        int[][] resultPixelArray = calculator.calcGraph();

        assertNotNull(resultPixelArray);
        assertEquals(2, resultPixelArray.length);
        assertEquals(100001, resultPixelArray[0].length);
    }
}
