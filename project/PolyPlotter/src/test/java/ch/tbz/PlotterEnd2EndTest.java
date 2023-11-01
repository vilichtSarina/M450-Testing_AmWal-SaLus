package ch.tbz;

import ch.tbz.graph.GraphPanel;
import ch.tbz.menu.GraphInputMenu;
import ch.tbz.menu.MainFrame;
import ch.tbz.menu.MenuPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlotterEnd2EndTest {

    private static MainFrame main;

    @BeforeAll
    public static void init() {
        main = new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    }

    @Test
    public void test_main_inputAndPlotGraph() {
        assertTrue(main.getCurrentPanel() instanceof MenuPanel);

        MenuPanel menu = (MenuPanel) main.getCurrentPanel();
        menu.getCustomGraph().doClick();

        assertTrue(main.getCurrentPanel() instanceof GraphInputMenu);
        GraphInputMenu graphInputMenu = (GraphInputMenu) main.getCurrentPanel();

        String fakeGraphInput = "x^2";
        graphInputMenu.getInputField().setText(fakeGraphInput);

        graphInputMenu.getCalcGraph().doClick();
        assertTrue(main.getCurrentPanel() instanceof GraphPanel);

        GraphPanel graphPanel = (GraphPanel) main.getCurrentPanel();
        BufferedImage image = graphPanel.getImg();

        // Specifically asking for these coordinates, since the parable will go through
        // the absolute 0 point of the coordinate system.
        assertEquals(Color.RED.getRGB(), image.getRGB(image.getHeight() / 2, image.getWidth() / 2));

        graphPanel.getGoBack().doClick();
        assertTrue(main.getCurrentPanel() instanceof GraphInputMenu);
    }
}
