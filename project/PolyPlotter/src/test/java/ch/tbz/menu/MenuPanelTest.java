package ch.tbz.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuPanelTest {

    private MainFrame main;
    private MenuPanel menu;

    @BeforeEach
    public void init() {
        main = new MainFrame(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        menu = new MenuPanel(main.getWidth(), main.getHeight(), main);
    }

    @Test
    public void testsComponents_RendersExitAndSave() {
        Assertions.assertNotNull(menu.getExitAndSave());
    }

    @Test
    public void testsComponents_RendersFractalButton() {
        Assertions.assertNotNull(menu.getFractalButton());
        assertDoesNotThrow(() -> menu.getFractalButton().doClick());
    }

    @Test
    public void testFractalButton_NavigatesToFractalMenu() {
        menu.getFractalButton().doClick();
        assertTrue(main.getCurrentPanel() instanceof FractalMenu);
    }
}
