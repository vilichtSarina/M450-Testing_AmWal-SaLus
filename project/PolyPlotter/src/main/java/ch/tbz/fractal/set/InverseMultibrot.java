package ch.tbz.fractal.set;

import ch.tbz.fractal.Fractal;

/**
 * This InverseMultibrot set is the result of a mathematical function, of which the complex numbers c are
 * inserted into f(z) = 1 / (z^3 + c). If the function with point c does not diverge to infinity, c belongs to the
 * set.
 * It is the mathematical inverse of the MultibrotSet.
 */
public class InverseMultibrot extends Fractal {

    public InverseMultibrot(int width, int height, double zoom, int maxIteration) {
        super(width, height, zoom, maxIteration);
    }

    /**
     * Iterates over all pixels, represented by a 2D array and stores the iteration count (obtained by calling calcSet())
     * per xy-coordinate.
     * This value will later on be used to render the fractal.
     *
     * @return 2D pixel-array with number of iterations per input value.
     */
    public int[][] getPixelIteration() {
        for (float i = 0; i < height; i++) {
            for (float j = 0; j < width; j++) {
                double yCvalue = ((i / width) * (X_MAX - X_MIN) + X_MIN) * zoom;
                double xCvalue = ((j / height) * (Y_MAX - Y_MIN) + Y_MIN) * zoom;

                pixelIterations[(int) i][(int) j] = calcSet(xCvalue, yCvalue);
            }
        }
        return pixelIterations;
    }

    /**
     * In order to determine whether a coordinate / a complex number tends to go to infinity when implemented in the
     * mathematical inverse of the mandelbrot (power 3) function, the calcSet method is used.
     *
     * @param xCvalue x-coordinate in the complex plane
     * @param yCvalue y-coordinate in the complex plane
     * @return the iteration count (either maxIteration when part of set or iterCount when not part of set)
     */
    public int calcSet(double xCvalue, double yCvalue) {
        float iterCount = 0;

        double xZtemp;
        double xZvalue = 0;
        double yZvalue = 0;

        double xCoord = xCvalue != 0 ? (xCvalue / (xCvalue * xCvalue + yCvalue * yCvalue)) : 0;
        double yCoord = yCvalue != 0 ? (yCvalue / (xCvalue * xCvalue + yCvalue * yCvalue)) : 0;

        double exponent = 3.0;

        while (iterCount < maxIteration && (xZvalue * xZvalue + yZvalue * yZvalue) < 4) {
            xZtemp = Math.pow(xZvalue * xZvalue + yZvalue * yZvalue, exponent / 2) * Math.cos(exponent * Math.atan2(yZvalue, xZvalue)) + xCoord;
            yZvalue = Math.pow(xZvalue * xZvalue + yZvalue * yZvalue, exponent / 2) * Math.sin(exponent * Math.atan2(yZvalue, xZvalue)) + yCoord;
            xZvalue = xZtemp;

            iterCount = iterCount + 1;
            if ((xZvalue * xZvalue) + (yZvalue * yZvalue) >= 4) {
                break;
            }
        }
        return (int) iterCount;
    }

}

