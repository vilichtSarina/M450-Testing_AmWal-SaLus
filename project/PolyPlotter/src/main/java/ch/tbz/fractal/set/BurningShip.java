package ch.tbz.fractal.set;

import ch.tbz.fractal.Fractal;

/**
 * The Burning ship set is the result of a mathematical function, of which the complex numbers c are
 * inserted into f(z) = abs(z)^2 + c. If the function with point c does not diverge to infinity, c belongs to the
 * set.
 */
public class BurningShip extends Fractal {

    public BurningShip(int width, int height, int maxIteration, double zoom, int[][] pixelIterations) {
        super(width, height, zoom, maxIteration);
    }

    /**
     * Iterates over all pixels, represented by a 2D array and stores the iteration count (obtained by calling calcSet())
     * per xy-coordinate.
     * This value will later on be used to render the fractal.
     *
     * @return 2D pixel-array with number of iterations per input value.
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
     * burning ship function, the calcSet method is used.
     * @param xCvalue x-coordinate in the complex plane
     * @param yCvalue y-coordinate in the complex plane
     * @return the iteration count (either maxIteration when part of set or iterCount when not part of set)
     */
    @Override
    public int calcSet(double xCvalue,double yCvalue) {
        float iterCount = 0;

        double xZtemp;
        double xZvalue = 0;
        double yZvalue = 0;

        while (iterCount < maxIteration) {
            xZtemp = (xZvalue * xZvalue) - (yZvalue * yZvalue) + xCvalue;
            yZvalue = 2 * Math.abs(xZvalue * yZvalue) + yCvalue;
            xZvalue = xZtemp;

            iterCount = iterCount + 1;
            if ((xZvalue * xZvalue) + (yZvalue * yZvalue) >= 4) {
                break;
            }
        }
        return (int)iterCount;
    }

}
