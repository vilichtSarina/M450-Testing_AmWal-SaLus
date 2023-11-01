package ch.tbz.graph;

import ch.tbz.graph.calculation.Graph;
import ch.tbz.graph.calculation.GraphPixelCalculator;
import ch.tbz.menu.GraphInputMenu;
import ch.tbz.menu.MainFrame;
import ch.tbz.menu.MenuPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphPanelTest {

    private MainFrame main;
    private GraphPanel graphPanel;

    private Graph getGraph(String fakeInputFieldContent, Color color) {
        return new Graph(new GraphPixelCalculator(fakeInputFieldContent, main.getWidth(), main.getHeight()).calcGraph(), Color.red);
    }

    @BeforeEach
    public void init() {
        main = new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    }

    @Test
    public void testGoBackButton_RendersAndNavigates() {
        graphPanel = new GraphPanel(getGraph("x^2", Color.red), main.getWidth(), main.getHeight(), main);
        assertTrue(graphPanel.getGoBack().isVisible());
        graphPanel.getGoBack().doClick();

        assertTrue(main.getCurrentPanel() instanceof GraphInputMenu);
    }

    @Test
    public void testRenderGraph_UsesCorrectColor() {
        graphPanel = new GraphPanel(getGraph("x^2", Color.red), main.getWidth(), main.getHeight(), main);
        BufferedImage image = graphPanel.getImg();
        // Specifically asking for these coordinates, since the parable will go through
        // the absolute 0 point of the coordinate system.
        assertEquals(Color.RED.getRGB(), image.getRGB(image.getHeight() / 2, image.getWidth() / 2));
    }

    @Test
    public void testGetGraph_ReturnsCorrectGraph() {
        Graph graph = getGraph("x^2", Color.red);
        graphPanel = new GraphPanel(graph, main.getWidth(), main.getHeight(), main);
        assertEquals(graphPanel.getGraph(), graph);
    }
}
