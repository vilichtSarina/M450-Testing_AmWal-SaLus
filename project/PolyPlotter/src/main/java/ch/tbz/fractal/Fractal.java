package ch.tbz.fractal;

/**
 * Base class of all fractals, which provides all the necessary common fields and methods.
 * The Fractal and its subclasses are used to make the calculations, which will be rendered by the FractalRenderer.
 */
public class Fractal {

    protected int height;
    protected int width;

    protected double zoom;

    protected int maxIteration;
    protected int[][] pixelIterations;

    protected static final double X_MAX = 2.0;
    protected static final double X_MIN = -2.0;
    protected static final double Y_MAX = 2.0;
    protected static final double Y_MIN = -2.0;

    public Fractal(int width, int height, double zoom, int maxIteration) {
        this.width = width;
        this.height = height;
        this.zoom = zoom;
        this.maxIteration = maxIteration;
        this.pixelIterations = new int[width][height];
    }

    /**
     * In order to determine whether a coordinate / a complex number tends to go to infinity when implemented in the
     * fractal's function, the calcSet method is used.
     * @param xCvalue x-coordinate in the complex plane
     * @param yCvalue y-coordinate in the complex plane
     * @return the iteration count (either maxIteration when part of set or iterCount when not part of set)
     */
    protected int calcSet(double xCvalue, double yCvalue) {
        return 1;
    }

    /**
     * @return the maximum amount of iterations until it can be assumed that a coordinate / complex number belongs
     * to the set.
     */
    public int getMaxIteration() {
        return maxIteration;
    }

    /**
     * Iterates over all pixels, represented by a 2D array and stores the iteration count (obtained by calling calcSet())
     * per xy-coordinate.
     * This value will later on be used to render the fractal.
     *
     * @return 2D pixel-array with number of iterations per input value.
     */
    public int[][] getPixelIterations() {
        return pixelIterations;
    }
}