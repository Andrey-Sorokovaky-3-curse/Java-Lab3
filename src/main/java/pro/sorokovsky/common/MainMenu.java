package pro.sorokovsky.common;

import pro.sorokovsky.level1.Level1Frame;
import pro.sorokovsky.level2.Level2Frame;

import javax.swing.*;

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
        panel.add(setupLevelOneButton());
        panel.add(setupLevelTwoButton());
    }

    private JButton setupLevelOneButton() {
        final var button = new JButton();
        button.setText("Рівень 1");
        button.addActionListener(_ -> new Level1Frame().setVisible(true));
        return button;
    }

    private JButton setupLevelTwoButton() {
        final var button = new JButton();
        button.setText("Рівень 2");
        button.addActionListener(_ -> new Level2Frame().setVisible(true));
        return button;
    }
}
