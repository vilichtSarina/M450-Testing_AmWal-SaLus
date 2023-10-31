package ch.tbz.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuPanelTest {

    private final MainFrame main = new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    private final MenuPanel menu = new MenuPanel(main.getWidth(), main.getHeight(), main);

    @Test
    public void tetsComponents_RendersExitAndSave() {
        Assertions.assertNotNull(menu.getExitAndSave());
        assertDoesNotThrow(() -> menu.getExitAndSave().doClick());
    }

    @Test
    public void tetsComponents_RendersFractalButton() {
        Assertions.assertNotNull(menu.getFractalButton());
        assertDoesNotThrow(() -> menu.getFractalButton().doClick());
    }

    @Test
    public void testFractalButton_NavigatesToFractalMenu() {
        menu.getFractalButton().doClick();
        assertTrue(main.getCurrentPanel() instanceof FractalMenu);
    }
}
