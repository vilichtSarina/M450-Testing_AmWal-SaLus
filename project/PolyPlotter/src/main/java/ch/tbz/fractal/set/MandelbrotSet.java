package ch.tbz.fractal.set;

import ch.tbz.fractal.Fractal;

/**
 * The Mandelbrot set is the result of a mathematical function, of which the complex numbers c are
 * inserted into f(z) = z^2 + c. If the function with point c does not diverge to infinity, c belongs to the
 * set.
 */
public class MandelbrotSet extends Fractal {

    public MandelbrotSet(int width, int height, double zoom, int maxIteration) {
        super(width, height, zoom, maxIteration);
    }

    /**
     * Iterates over all pixels, represented by a 2D array and stores the iteration count (obtained by calling calcSet())
     * per xy-coordinate.
     * This value will later on be used to render the fractal.
     *
     * @return 2D pixel-array with number of iterations per input value.
     *
     * Unit test not needed, since the result of getPixelIterations() is
     * completely coupled to the functionality of calcSet().
     */
    @Override
    public int[][] getPixelIterations() {
        for (float i = 0; i < height; i++) {
            for (float j = 0; j < width; j++) {
                double yCvalue = ((i / width) * (X_MAX - X_MIN) + X_MIN);
                double xCvalue = ((j / height) * (Y_MAX - Y_MIN) + Y_MIN);

                pixelIterations[(int)i][(int)j] = calcSet(xCvalue, yCvalue);
            }
        }
        return pixelIterations;
    }

    /**
     * In order to determine whether a coordinate / a complex number tends to go to infinity when implemented in the
     * Mandelbrot function, the calcSet method is used.
     * @param xCvalue x-coordinate in the complex plane
     * @param yCvalue y-coordinate in the complex plane
     * @return the iteration count (either maxIteration when part of set or iterCount when not part of set)
     */
    @Override
    public int calcSet(double xCvalue,double yCvalue) {
        float iterationCount = 0;

        double xZtemp;
        double xZvalue = 0;
        double yZvalue = 0;

        while (iterationCount < maxIteration) {
            xZtemp = (xZvalue * xZvalue) - (yZvalue * yZvalue) + xCvalue;
            yZvalue = 2 * xZvalue * yZvalue + yCvalue;
            xZvalue = xZtemp;

            iterationCount = iterationCount + 1;
            if ((xZvalue * xZvalue) + (yZvalue * yZvalue) >= 4) {
                break;
            }
        }
        return (int)iterationCount;
    }

}
