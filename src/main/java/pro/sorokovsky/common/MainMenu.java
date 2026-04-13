package pro.sorokovsky.common;

import pro.sorokovsky.level1.Level1Frame;
import pro.sorokovsky.level2.Level2Frame;
import pro.sorokovsky.level3.Level3Frame;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private final JPanel panel = new JPanel();

    public MainMenu() {
        setup();
    }

    private void setupFrame() {
        setTitle("Головне меню");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setup() {
        setupFrame();
        setupButtons();
        add(panel);
    }

    private void setupButtons() {
        panel.add(generateButton("Рівень 1", Level1Frame::new));
        panel.add(generateButton("Рівень 2", Level2Frame::new));
        panel.add(generateButton("Рівень 3", Level3Frame::new));
    }

    private JButton generateButton(String text, FrameSupplier supplier) {
        final var button = new JButton(text);
        button.addActionListener(_ -> supplier.get().setVisible(true));
        return button;
    }

    @FunctionalInterface
    private interface FrameSupplier {
        Frame get() throws HeadlessException;
    }
}
