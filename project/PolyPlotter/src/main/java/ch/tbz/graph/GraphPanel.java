package ch.tbz.graph;

import ch.tbz.graph.calculation.Graph;
import ch.tbz.menu.GraphInputMenu;
import ch.tbz.menu.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import static ch.tbz.graph.calculation.GraphPixelCalculator.YCALCS;

/**
 * Displays all the graphs inside of it with the option to return to the graph menu.
 */
public class GraphPanel extends JPanel implements ActionListener {

    private int stdWidth;
    private int stdHeight;

    private MainFrame main;

    private JButton goBack = new JButton("Go Back");

    private Graphics2D g2;
    private BufferedImage img;
    private int[] buffer;
    private Graph graph;

    public GraphPanel(Graph graph, int stdWidth, int stdHeight, MainFrame main) {
        this.stdWidth = stdWidth;
        this.stdHeight = stdHeight;
        this.main = main;
        img = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        g2 = (Graphics2D) img.getGraphics();
        buffer = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
        this.graph = graph;

        this.setPreferredSize(new Dimension(stdWidth, stdHeight));

        goBack.addActionListener(this);
        goBack.setVisible(true);
        this.add(goBack);

        main.getContentPane().setVisible(true);
        main.getContentPane().revalidate();
        main.getContentPane().repaint();

        renderFields();
    }

    /**
     * Does the actual rendering of the coordinate system
     */
    public void renderFields() {

        g2.setColor(Color.black);
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());

        /*~~~~~small sections for y~~~~~~*/
        g2.setColor(Color.DARK_GRAY.darker());
        g2.drawLine((img.getWidth() / 8), 0, (img.getWidth() / 8), img.getHeight());
        g2.drawLine((img.getWidth() / 4), 0, (img.getWidth() / 4), img.getHeight());
        g2.drawLine(3 * (img.getWidth() / 8), 0, 3 * (img.getWidth() / 8), img.getHeight());
        g2.drawLine(5 * (img.getWidth() / 8), 0, 5 * (img.getWidth() / 8), img.getHeight());
        g2.drawLine(6 * (img.getWidth() / 8), 0, 6 * (img.getWidth() / 8), img.getHeight());
        g2.drawLine(7 * (img.getWidth() / 8), 0, 7 * (img.getWidth() / 8), img.getHeight());

        /*~~~~~~small sections for x~~~~~~*/
        g2.drawLine(0, (img.getHeight() / 8), img.getWidth(), (img.getHeight() / 8));
        g2.drawLine(0, (img.getHeight() / 4), img.getWidth(), (img.getHeight() / 4));
        g2.drawLine(0, 3 * (img.getHeight() / 8), img.getWidth(), 3 * (img.getHeight() / 8));
        g2.drawLine(0, 5 * (img.getHeight() / 8), img.getWidth(), 5 * (img.getHeight() / 8));
        g2.drawLine(0, 6 * (img.getHeight() / 8), img.getWidth(), 6 * (img.getHeight() / 8));
        g2.drawLine(0, 7 * (img.getHeight() / 8), img.getWidth(), 7 * (img.getHeight() / 8));

        /*~~~~~~big sections~~~~~~~~*/
        g2.setColor(Color.DARK_GRAY.brighter().brighter());
        g2.setStroke(new BasicStroke(1));
        g2.drawLine((img.getWidth() / 2), 0, (img.getWidth() / 2), img.getHeight());
        g2.drawLine(0, img.getHeight() / 2, img.getWidth(), img.getHeight() / 2);

        renderGraph(graph.getCoordinates(), graph.getColor());
    }

    /**
     * Renders the graph according to coordinates
     * @param coordinates given coordinates for function
     * @param color of the graph
     */
    public void renderGraph(int[][] coordinates, Color color) {

        int myColor = color.getRGB();

        for (int i = 0; i < YCALCS; i++) {
            int row = coordinates[1][i];
            int col = coordinates[0][i];
            if (coordinates[1][i] >= 0 && coordinates[1][i] < img.getWidth()
                    && coordinates[0][i] >= 0 && coordinates[0][i] < img.getHeight()) {
                img.setRGB(col, row, myColor);
            }
        }
    }

    /**
     * Draws the buffered image, uncovered in unit tests.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.drawImage(img, 0, 0, this);
    }

    /**
     * Executes action for GoBack button
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            main.getContentPane().removeAll();
            JPanel inputMenu = new GraphInputMenu(stdWidth, stdHeight, main);
            main.setCurrentPanel(inputMenu);
            main.getContentPane().add(inputMenu);
        }
    }
    public MainFrame getMain() {
        return main;
    }

    public JButton getGoBack() {
        return goBack;
    }

    public BufferedImage getImg() {
        return img;
    }

    public Graph getGraph() {
        return graph;
    }
}
