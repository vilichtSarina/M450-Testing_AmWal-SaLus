package ch.tbz;

import ch.tbz.menu.MainFrame;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

/**
 * Starter class, from which the program flow is started
 */
public class Starter {

    /**
     * Main method, which provides the entry point tp the application,
     * by opening up the MainFrame and applying the FlatLaF theme.
     * @param args unused
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {}
        new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    }
}