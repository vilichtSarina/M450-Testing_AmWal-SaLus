package ch.tbz.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MenuPanelTest {

    private final MainFrame main = new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    private final MenuPanel menu = new MenuPanel(main.getWidth(), main.getHeight(), main);

    @Test
    public void tetsComponents_RendersExitAndSave() {
        Assertions.assertTrue(menu.getExitAndSave() instanceof JButton);
        assertDoesNotThrow(() -> menu.getExitAndSave().doClick());
    }

    @Test
    public void tetsComponents_RendersFractalButton() {
        Assertions.assertTrue(menu.getFractalButton() instanceof JButton);
        assertDoesNotThrow(() -> menu.getFractalButton().doClick());
    }
}
