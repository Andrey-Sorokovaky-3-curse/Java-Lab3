package pro.sorokovsky.level1;

import javax.swing.*;

public class Level1Frame extends JFrame {
    private final JPanel panel = new JPanel();

    public Level1Frame() {
        basicSetup();
        addTextField();
        addSetButton();
        add(panel);
    }

    private void basicSetup() {
        setTitle("Рівень 1");
        setSize(800, 600);
    }

    private void addTextField() {
        final var textField = new JTextField();
        panel.add(textField);
    }

    private void addSetButton() {
        final var button = new JButton("Set");
        panel.add(button);
    }
}
