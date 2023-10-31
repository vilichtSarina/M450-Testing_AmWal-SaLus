package ch.tbz.menu;

import ch.tbz.fractal.FractalRenderer;
import ch.tbz.fractal.set.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class FractalMenuTest {

    private MainFrame main;
    private FractalMenu menu;

    @BeforeEach
    public void resetMenu() {
        main = new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        menu = new FractalMenu(main.getWidth(), main.getHeight(), main);
    }

    @Test
    public void testGoBack_NavigatesToMainMenu() {
        menu.getGoBack().doClick();
        assertTrue(main.getCurrentPanel() instanceof MenuPanel);
    }

    @Test
    public void testMandelBrotSetButton_NavigatesToAndDisplaysFractal() {
        assertDoesNotThrow(() -> menu.getMandelbrotSetButton().doClick());

        assertTrue(main.getCurrentPanel() instanceof FractalRenderer);
        assertTrue(((FractalRenderer) main.getCurrentPanel()).getFractal() instanceof MandelbrotSet);
    }

    @Test
    public void testJuliaSetButton_NavigatesToAndDisplaysFractal() {
        assertDoesNotThrow(() -> menu.getJuliaSetButton().doClick());

        assertTrue(main.getCurrentPanel() instanceof FractalRenderer);
        assertTrue(((FractalRenderer) main.getCurrentPanel()).getFractal() instanceof JuliaSet);
    }

    @Test
    public void testBurningShipButton_NavigatesToAndDisplaysFractal() {
        assertDoesNotThrow(() -> menu.getBurningShipButton().doClick());

        assertTrue(main.getCurrentPanel() instanceof FractalRenderer);
        assertTrue(((FractalRenderer) main.getCurrentPanel()).getFractal() instanceof BurningShip);
    }

    @Test
    public void testTricornSetButton_NavigatesToAndDisplaysFractal() {
        assertDoesNotThrow(() -> menu.getTricornSetButton().doClick());

        assertTrue(main.getCurrentPanel() instanceof FractalRenderer);
        assertTrue(((FractalRenderer) main.getCurrentPanel()).getFractal() instanceof TricornSet);
    }

    @Test
    public void testMultiBrotSetButton_NavigatesToAndDisplaysFractal() {
        assertDoesNotThrow(() -> menu.getMultibrotSetButton().doClick());

        assertTrue(main.getCurrentPanel() instanceof FractalRenderer);
        assertTrue(((FractalRenderer) main.getCurrentPanel()).getFractal() instanceof MultibrotSet);
    }

    @Test
    public void testInvertedMultibrotSetButton_NavigatesToAndDisplaysFractal() {
        assertDoesNotThrow(() -> menu.getInvertedMultibrotButton().doClick());

        assertTrue(main.getCurrentPanel() instanceof FractalRenderer);
        assertTrue(((FractalRenderer) main.getCurrentPanel()).getFractal() instanceof InverseMultibrot);
    }
}
