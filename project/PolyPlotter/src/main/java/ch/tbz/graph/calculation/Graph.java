package ch.tbz.graph.calculation;

import java.awt.*;

/**
 * Class that contains the pixel array of a function along with its color
 */
public class Graph {

    private int[][] coordinates;
    private Color color;

    public Graph(int[][] coordinates, Color color) {
        this.coordinates = coordinates;
        this.color = color;
    }

    /**
     *
     * @return graph coordinates
     */
    public int[][] getCoordinates() {
        return coordinates;
    }

    /**
     *
     * @return the graph's color
     */
    public Color getColor() {
        return color;
    }
}
