package ch.tbz.fractal;

import ch.tbz.menu.MainFrame;
import ch.tbz.menu.MenuPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FractalRendererTest {

    private static MainFrame main;
    private static FractalRenderer fractalRenderer;

    @BeforeAll
    public static void init() {
        main = new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        fractalRenderer = new FakeFractalRenderer(main);
    }

    @Test
    public void testContainsGoBackButton() {
        assertTrue(fractalRenderer.getGoBack().isVisible());
        assertDoesNotThrow(() -> fractalRenderer.getGoBack().doClick());
    }

    @Test
    public void testFractalRenderer_isDisplayed() {
        assertTrue(fractalRenderer.isVisible());
    }

    @Test
    public void test_navigateBackToMainMenu() {
        fractalRenderer.getGoBack().doClick();
        assertTrue(main.getCurrentPanel() instanceof MenuPanel);
    }
}
