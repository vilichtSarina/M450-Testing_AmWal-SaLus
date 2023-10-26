package ch.tbz.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu that handles the custom graph entering
 */
public class GraphInputMenu extends JPanel implements ActionListener {

    private int stdWidth;
    private int stdHeight;

    private MainFrame main;
    private JButton calcGraph = new JButton("Calculate Graph");
    private JButton goBack = new JButton("Go Back");

    private JTextField inputField = new JTextField("Enter function");

    public GraphInputMenu(int stdWidth, int stdHeight, MainFrame main) {
        this.stdWidth = stdWidth;
        this.stdHeight = stdHeight;
        this.main = main;

        this.setPreferredSize(new Dimension(stdWidth, stdHeight));
        this.setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 5;

        JLabel format = new JLabel("y = ");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        this.add(format, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        this.add(inputField, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        this.add(calcGraph, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        goBack.addActionListener(this);
        this.add(goBack, gbc);

        main.getContentPane().add(this);
        main.getContentPane().revalidate();
        main.getContentPane().repaint();
    }

    /**
     * Either to handle GoBack button action or to submit the entered function string. If valid, it opens up the GraphPanel.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            main.getContentPane().removeAll();
            main.getContentPane().add(new MenuPanel(stdWidth, stdHeight, main));
        }
    }
}
