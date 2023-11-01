package ch.tbz.menu;

import ch.tbz.exception.ParenthesesMismatchException;
import ch.tbz.graph.GraphPanel;
import ch.tbz.graph.calculation.Graph;
import ch.tbz.graph.calculation.GraphPixelCalculator;
import ch.tbz.graph.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu that handles entering the function that is used to create a custom graph.
 */
public class GraphInputMenu extends JPanel implements ActionListener {

    private int stdWidth;
    private int stdHeight;

    private MainFrame main;
    private JButton calcGraph = new JButton("Calculate Graph");
    private JButton goBack = new JButton("Go Back");

    private JLabel inputError = new JLabel("Your function doesn't follow a valid format.");
    private JTextField inputField = new JTextField("Enter function");
    private Validator validator;

    public GraphInputMenu(int stdWidth, int stdHeight, MainFrame main) {
        this.stdWidth = stdWidth;
        this.stdHeight = stdHeight;
        this.main = main;

        this.setPreferredSize(new Dimension(stdWidth, stdHeight));

        configureComponents();

        validator = new Validator("");


        main.getContentPane().add(this);
        main.getContentPane().revalidate();
        main.getContentPane().repaint();
    }

    /**
     * Sets the layout to GridBagLayout and configures the GridBagConstraints.
     *
     * @return GridBagConstraints the configured GridBagConstraints for layout handling.
     */
    private void configureComponents(){
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 5;
        errorSetup(gbc);

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
        calcGraph.addActionListener(this);
        this.add(calcGraph, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        goBack.addActionListener(this);
        this.add(goBack, gbc);
    }

    private void errorSetup(GridBagConstraints gbc){
        inputError.setForeground(Color.red);
        inputError.setVisible(false);
        this.add(inputError, gbc);
    }

    /**
     * Either to handle GoBack button action or to submit the entered function string. If valid, it opens up the GraphPanel.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcGraph) {
            validator.setInput(inputField.getText());
            if (validator.isValidInput()) {
                try {
                    main.getContentPane().removeAll();
                    Graph myGraph = new Graph(new GraphPixelCalculator(inputField.getText(), stdWidth, stdHeight).calcGraph(), Color.red);
                    GraphPanel panel = new GraphPanel(myGraph, stdWidth, stdHeight, main);
                    main.setCurrentPanel(panel);
                    main.getContentPane().add(panel);
                } catch (ParenthesesMismatchException pme) {
                    main.getContentPane().add(this);
                    inputError.setVisible(true);
                }
            } else {
                inputError.setVisible(true);
            }
        } else if (e.getSource() == goBack) {
            main.getContentPane().removeAll();
            MenuPanel panel = new MenuPanel(stdWidth, stdHeight, main);
            main.setCurrentPanel(panel);
            main.getContentPane().add(panel);
        }
    }

    public JButton getGoBack() {
        return goBack;
    }
    public JTextField getInputField() {
        return inputField;
    }

    public JButton getCalcGraph() {
        return calcGraph;
    }
}
