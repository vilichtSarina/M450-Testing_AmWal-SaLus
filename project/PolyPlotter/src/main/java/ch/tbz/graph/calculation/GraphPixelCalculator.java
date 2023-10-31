package ch.tbz.graph.calculation;

import ch.tbz.exception.ParenthesesMismatchException;
import ch.tbz.graph.interpreter.Interpreter;

import java.util.List;
import java.util.Stack;

/**
 * Calculates the entire graph's coordinates given a generic String input.
 */
public class GraphPixelCalculator {

    /**
     * Variable that is used when calculating the y-coordinate.
     */
    public static int YCALCS = 100000;

    private double xMin;
    private double xMax;

    private double xUnit;
    private int yUnit;

    private int[][] pixelArr;
    private List<String> parsedInput;
    private Interpreter interpreter;

    private static double y;
    private static double x;

    private int offsetX;
    private int offsetY;

    public GraphPixelCalculator(String input, int stdWidth, int stdHeight) throws ParenthesesMismatchException {
        this.xUnit = 100;
        this.yUnit = 100;
        this.offsetX = 400;
        this.offsetY = 400;
        this.pixelArr = new int[2][YCALCS + 1];

        this.xMax = 4;
        this.xMin = -4;
        this.x = xMin;
        this.y = 0;

        interpreter = new Interpreter();

        this.parsedInput = interpreter.convertToReversePolishNotation(input);
        calcGraph();
    }

    /**
     * Iterates over x coordinates to find y coordinate
     * @return the pixel array
     */
    public int[][] calcGraph() {
        x = xMin;
        double dif = xMax - xMin;
        double step = dif / YCALCS;
        for (int i = 0; i <= YCALCS; i++) {

            y = (interpreter.getYForParsedInput(x, xMin, parsedInput));

            if (!Double.isNaN(y * -1)
                    && !Double.isInfinite(y * -1)) {
                pixelArr[0][i] = (int) (x * xUnit) + offsetX;
                pixelArr[1][i] = (int) ((y * -1) * yUnit) + offsetY;
            }

            x = (double) Math.round((x + step) * 100000000d) / 100000000d;
        }
        return pixelArr;
    }

    /**
     * Used to get current x coordinate
     * @return
     */
    public static double getX() {
        return x;
    }

    /**
     * used to set current x coordinate
     * @param x
     */
    public static void setX(double x) {
        GraphPixelCalculator.x = x;
    }

}
