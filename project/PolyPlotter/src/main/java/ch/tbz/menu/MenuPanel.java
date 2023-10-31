package ch.tbz.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the first menu that is opened when the program is started and offers different buttons to open up further menus.
 */
public class MenuPanel extends JPanel implements ActionListener {

    private int stdWidth;
    private int stdHeight;

    private MainFrame main;

    private JButton fractalButton = new JButton();
    private JButton exitAndSave = new JButton("Save & Quit");

    public MenuPanel(int stdWidth, int stdHeight, MainFrame main) {
        this.stdWidth = stdWidth;
        this.stdHeight = stdHeight;

        this.main = main;

        this.setPreferredSize(new Dimension(stdWidth, stdHeight));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        exitAndSave.addActionListener(this);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 10;
        this.add(fractalButton, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 5;
        this.add(exitAndSave, gbc);

        createMenuButtons();

        main.add(this);
        revalidate();
        repaint();
        main.revalidate();
        main.repaint();
    }

    /**
     * Helper method that inserts the different menu buttons into the panel
     */
    private void createMenuButtons() {
        fractalButton.setPreferredSize(new Dimension(500, 600));
        fractalButton.setText("Plot Fractal");
        fractalButton.setVisible(true);
        fractalButton.addActionListener(this);
    }

    /**
     * Used to execute action to either end the program, open the fractal menu or open up the graph menu.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fractalButton) {
            main.getContentPane().removeAll();
            main.getContentPane().add(new FractalMenu(stdWidth, stdHeight, main));
        } else if (e.getSource() == exitAndSave) {
            System.exit(0);
        }
    }

    public int getStdWidth() {
        return stdWidth;
    }

    public int getStdHeight() {
        return stdHeight;
    }

    public MainFrame getMain() {
        return main;
    }

    public JButton getFractalButton() {
        return fractalButton;
    }

    public JButton getExitAndSave() {
        return exitAndSave;
    }
}
