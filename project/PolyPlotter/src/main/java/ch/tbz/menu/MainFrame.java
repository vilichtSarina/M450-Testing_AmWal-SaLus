package ch.tbz.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The MainFrame class acts as the main ui window. Its contents are switchd out, depending on which component is chosen to be rendered.
 * It extends the swing class JFrame, by which it has access to some of the functions used i.e. revalidate(), removeAll()...
 */
public class MainFrame extends JFrame {
    private JPanel currentPanel;

    /**
     * The MainFrame constructor applies some default configuration for the frame.
     * @param stdWidth the width of the window
     * @param stdHeight the height of the window
     */
    public MainFrame(int stdWidth, int stdHeight) {

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        if (stdWidth > screenWidth) {
            this.setExtendedState(Frame.MAXIMIZED_BOTH);
        }

        currentPanel = new MenuPanel(stdWidth, stdHeight, this);

        this.setSize(screenWidth / 2, screenHeight / 2);
        this.setLocationRelativeTo(null);
        this.add(currentPanel);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                SwingUtilities.updateComponentTreeUI(getContentPane());
                repaint();
                getContentPane().repaint();
            }
        });
    }
}
