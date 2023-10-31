package ch.tbz.fractal;

import ch.tbz.menu.FakeFractalRenderer;
import ch.tbz.menu.MainFrame;
import ch.tbz.menu.MenuPanel;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FractalRendererTest {

    private final MainFrame main = new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    private final FractalRenderer fractalRenderer = new FakeFractalRenderer(main);
    @Test
    public void testContainsGoBackButton() {
        assertTrue(fractalRenderer.getGoBack().isVisible());
        assertDoesNotThrow(() -> fractalRenderer.getGoBack().doClick());
    }
}
