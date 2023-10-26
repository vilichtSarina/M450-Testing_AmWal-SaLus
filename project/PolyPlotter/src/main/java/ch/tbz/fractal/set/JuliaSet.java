package ch.tbz.fractal.set;

import ch.tbz.fractal.Fractal;

/**
 * The Julia set is the result of a mathematical function, of which the complex numbers c are
 * inserted into f(z) = z^2 + c.
 * Contrary to the MandelbrotSet, this fractal has a constant c value, iterating over the z points.
 */
public class JuliaSet extends Fractal {

    private final double xcValue;
    private final double ycValue;

    public JuliaSet(int width, int height, double zoom, int maxIteration, double xcValue, double ycValue) {
        super(width, height, zoom, maxIteration);

        this.xcValue = xcValue;
        this.ycValue = ycValue;
    }

    /**
     * Iterates over all pixels, represented by a 2D array and stores the iteration count (obtained by calling
     * calcJuliaSet() per xy-coordinate.
     * This value will later on be used to render the fractal.
     *
     * @return 2D pixel-array with number of iterations per input value.
     */
    @Override
    public int[][] getPixelIterations() {
        for (float i = 0; i < height; i++) {
            for (float j = 0; j < width; j++) {
                double yZValue = ((i / width) * (X_MAX - X_MIN) + X_MIN) * zoom;
                double xZValue = ((j / height) * (Y_MAX - Y_MIN) + Y_MIN) * zoom;

                pixelIterations[(int)i][(int)j] = calcJuliaSet(xZValue, yZValue);
            }
        }
        return pixelIterations;
    }

    /**
     * In order to determine whether a coordinate / a complex number tends to go to infinity when implemented in the
     * Mandelbrot function, the calcSet method is used.
     * @param xZValue x-coordinate in the complex plane
     * @param yZValue y-coordinate in the complex plane
     * @return the iteration count (either maxIteration when part of set or iterCount when not part of set)
     */
    public int calcJuliaSet(double xZValue,double yZValue) {
        float iterCount = 0;
        double xZTemp;

        while (iterCount < maxIteration) {
            xZTemp = (xZValue * xZValue) - (yZValue * yZValue) + xcValue;
            yZValue = 2 * xZValue * yZValue + ycValue;
            xZValue = xZTemp;

            iterCount = iterCount + 1;
            if ((xZValue * xZValue) + (yZValue * yZValue) >= 4) {
                break;
            }
        }
        return (int)iterCount;
    }
}
