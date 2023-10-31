package ch.tbz.fractal;

import ch.tbz.fractal.FractalRenderer;
import ch.tbz.menu.MainFrame;

public class FakeFractalRenderer extends FractalRenderer {
    public FakeFractalRenderer(MainFrame main) {
        super(new int[2][100], 1.0, 1000, null, main);
    }
}
