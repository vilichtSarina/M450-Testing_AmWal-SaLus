package ch.tbz.fractal;

import ch.tbz.menu.FractalMenu;
import ch.tbz.menu.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class FractalRenderer extends JPanel implements ActionListener {
    private int[][] iterations;
    private int maxIt;

    private BufferedImage img;

    private MainFrame main;

    private JButton goBack = new JButton("Go Back");

    public FractalRenderer(int[][] iterations, double scale, int maxIt, Fractal fractal, MainFrame main) {
        this.iterations = iterations;
        this.main = main;

        this.maxIt = maxIt;

        int imageWidth = iterations.length;
        int imageHeight = iterations.length;

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

        this.setPreferredSize(new Dimension(imageWidth, imageHeight));

        goBack.addActionListener(this);
        this.add(goBack);

        main.getContentPane().setVisible(true);
        main.getContentPane().revalidate();
        main.getContentPane().repaint();
    }


    public static int[] hslToRgb(float[] hsl) {
        float h = hsl[0];
        float s = hsl[1];
        float l = hsl[2];
        if (s < 0.0f || s > 100.0f) {
            String message = "Color parameter outside of expected range - Saturation";
            throw new IllegalArgumentException(message);
        }

        if (l < 0.0f || l > 100.0f) {
            String message = "Color parameter outside of expected range - Luminance";
            throw new IllegalArgumentException(message);
        }

        //  Formula needs all values between 0 - 1.

        h = h % 360.0f;
        h /= 360f;
        s /= 100f;
        l /= 100f;

        float q = 0;

        if (l < 0.5) {
            q = l * (1 + s);
        } else {
            q = (l + s) - (s * l);
        }
        float p = 2 * l - q;

        int r = Math.round(Math.max(0, hueToRGB(p, q, h + (1.0f / 3.0f)) * 255));
        int g = Math.round(Math.max(0, hueToRGB(p, q, h) * 255));
        int b = Math.round(Math.max(0, hueToRGB(p, q, h - (1.0f / 3.0f)) * 255));

        return new int[]{r, g, b};
    }

    /**
     * Converts the HSL values to RGB
     * @param p
     * @param q
     * @param h
     * @return
     */
    private static float hueToRGB(float p, float q, float h) {
        if (h < 0) {
            h += 1;
        }
        if (h > 1) {
            h -= 1;
        }
        if (6 * h < 1) {
            return p + ((q - p) * 6 * h);
        }
        if (2 * h < 1) {
            return q;
        }
        if (3 * h < 2) {
            return p + ((q - p) * 6 * ((2.0f / 3.0f) - h));
        }
        return p;
    }

    /**
     * Converts the iteration count inside the pixel-array to a corresponding HSL
     * color scheme value.
     *
     * @param iterations how many iterations it took for the set's function to diverge
     * @return array[3] with each index representing one component of HSL
     */
    private float[] getHslValues(int iterations) {
        float hue = 255.0f * iterations / maxIt;
        float saturation = 100.0f;
        float value = iterations < maxIt ? 35 : 0;

        return new float[]{hue, saturation, value};
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int y = 0; y < iterations.length; y++) {
            for (int x = 0; x < iterations.length; x++) {
                int red = hslToRgb(getHslValues(iterations[y][x]))[0];
                int green = hslToRgb(getHslValues(iterations[y][x]))[1];
                int blue = hslToRgb(getHslValues(iterations[y][x]))[2];
                Color mycolor = new Color(red, green, blue);
                img.setRGB(x, y, mycolor.getRGB());
            }
        }

        g2d.drawImage(img, 0, 0, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            main.getContentPane().removeAll();
            main.getContentPane().add(new FractalMenu(main.getWidth(), main.getHeight(), main));
        }
    }

    public int[][] getIterations() {
        return iterations;
    }

    public int getMaxIt() {
        return maxIt;
    }

    public BufferedImage getImg() {
        return img;
    }

    public MainFrame getMain() {
        return main;
    }

    public JButton getGoBack() {
        return goBack;
    }
}