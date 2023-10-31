package ch.tbz.menu;

import ch.tbz.fractal.FractalRenderer;
import ch.tbz.fractal.set.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalMenu extends JPanel implements ActionListener {
    private int stdWidth;
    private int stdHeight;

    private JButton mandelbrotSetButton = new JButton();
    private JButton juliaSetButton = new JButton();
    private JButton burningShipButton = new JButton();
    private JButton multibrotSetButton = new JButton();
    private JButton tricornSetButton = new JButton();
    private JButton invertedMultibrotButton = new JButton();

    private JButton goBack = new JButton("Go Back");

    private MainFrame main;

    public FractalMenu(int stdWidth, int stdHeight, MainFrame main) {
        this.stdWidth = stdWidth;
        this.stdHeight = stdHeight;

        this.main = main;

        this.setPreferredSize(new Dimension(stdWidth, stdHeight));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        goBack.addActionListener(this);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 10;
        this.add(mandelbrotSetButton, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 10;
        this.add(juliaSetButton, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 10;
        this.add(burningShipButton, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 10;
        this.add(multibrotSetButton, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 10;
        this.add(tricornSetButton, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 10;
        this.add(invertedMultibrotButton, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.gridwidth = 5;
        this.add(goBack, gbc);

        createMenuButtons();

        main.add(this);
        revalidate();
        repaint();
        main.revalidate();
        main.repaint();
    }

    private void createMenuButtons() {
        mandelbrotSetButton.setPreferredSize(new Dimension(500, 600));
        mandelbrotSetButton.setText("Mandelbrot Set");
        mandelbrotSetButton.setVisible(true);
        mandelbrotSetButton.addActionListener(this);

        juliaSetButton.setPreferredSize(new Dimension(500, 600));
        juliaSetButton.setText("Julia Set");
        juliaSetButton.setVisible(true);
        juliaSetButton.addActionListener(this);

        burningShipButton.setPreferredSize(new Dimension(500, 600));
        burningShipButton.setText("Burning Ship");
        burningShipButton.setVisible(true);
        burningShipButton.addActionListener(this);

        multibrotSetButton.setPreferredSize(new Dimension(500, 600));
        multibrotSetButton.setText("Multibrot Set");
        multibrotSetButton.setVisible(true);
        multibrotSetButton.addActionListener(this);

        tricornSetButton.setPreferredSize(new Dimension(500, 600));
        tricornSetButton.setText("Tricorn Set");
        tricornSetButton.setVisible(true);
        tricornSetButton.addActionListener(this);

        invertedMultibrotButton.setPreferredSize(new Dimension(500, 600));
        invertedMultibrotButton.setText("Inverted Multibrot Set");
        invertedMultibrotButton.setVisible(true);
        invertedMultibrotButton.addActionListener(this);

    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mandelbrotSetButton) {
            main.getContentPane().removeAll();
            MandelbrotSet mSet = new MandelbrotSet(800, 800, 1.0, 100);
            FractalRenderer fractalRenderer = new FractalRenderer(mSet.getPixelIterations(), 2, mSet.getMaxIteration(), mSet, main);
            main.setCurrentPanel(fractalRenderer);
            main.getContentPane().add(fractalRenderer);
        } else if (e.getSource() == juliaSetButton) {
            main.getContentPane().removeAll();
            JuliaSet jSet = new JuliaSet(800, 800, 1.0, 70, -0.5, 0.6);
            FractalRenderer fractalRenderer = new FractalRenderer(jSet.getPixelIterations(), 2, jSet.getMaxIteration(), jSet, main);
            main.setCurrentPanel(fractalRenderer);
            main.getContentPane().add(fractalRenderer);
        } else if (e.getSource() == goBack) {
            main.getContentPane().removeAll();
            main.getContentPane().add(new MenuPanel(stdWidth, stdHeight, main));
        } else if (e.getSource() == burningShipButton) {
            main.getContentPane().removeAll();
            BurningShip burningShip = new BurningShip(800, 800, 100, 1.0, new int[800][800]);
            FractalRenderer fractalRenderer = new FractalRenderer(burningShip.getPixelIterations(), 2, burningShip.getMaxIteration(), burningShip, main);
            main.setCurrentPanel(fractalRenderer);
            main.getContentPane().add(fractalRenderer);
        } else if (e.getSource() == multibrotSetButton) {
            main.getContentPane().removeAll();
            MultibrotSet multiSet = new MultibrotSet(800, 800, 1, 100);
            FractalRenderer fractalRenderer = new FractalRenderer(multiSet.getPixelIterations(), 2, multiSet.getMaxIteration(), multiSet, main);
            main.setCurrentPanel(fractalRenderer);
            main.getContentPane().add(fractalRenderer);
        } else if (e.getSource() == tricornSetButton) {
            main.getContentPane().removeAll();
            TricornSet tSet = new TricornSet(800, 800, 1, 100);
            FractalRenderer fractalRenderer = new FractalRenderer(tSet.getPixelIterations(), 2, tSet.getMaxIteration(), tSet, main);
            main.setCurrentPanel(fractalRenderer);
            main.getContentPane().add(fractalRenderer);
        } else if (e.getSource() == invertedMultibrotButton) {
            main.getContentPane().removeAll();
            InverseMultibrot iSet = new InverseMultibrot(800, 800, 2, 100);
            FractalRenderer fractalRenderer = new FractalRenderer(iSet.getPixelIteration(), 2, iSet.getMaxIteration(), iSet, main);
            main.setCurrentPanel(fractalRenderer);
            main.getContentPane().add(fractalRenderer);
        }
    }

    public int getStdWidth() {
        return stdWidth;
    }

    public int getStdHeight() {
        return stdHeight;
    }

    public JButton getMandelbrotSetButton() {
        return mandelbrotSetButton;
    }

    public JButton getJuliaSetButton() {
        return juliaSetButton;
    }

    public JButton getBurningShipButton() {
        return burningShipButton;
    }

    public JButton getMultibrotSetButton() {
        return multibrotSetButton;
    }

    public JButton getTricornSetButton() {
        return tricornSetButton;
    }

    public JButton getInvertedMultibrotButton() {
        return invertedMultibrotButton;
    }

    public JButton getGoBack() {
        return goBack;
    }

    public MainFrame getMain() {
        return main;
    }
}
