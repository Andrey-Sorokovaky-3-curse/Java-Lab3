package pro.sorokovsky.level1;

import javax.swing.*;
import java.awt.*;

public class Level1Frame extends JFrame {
    public Level1Frame() throws HeadlessException {
        setTitle("Рівень 1");
        setSize(800, 600);
        setLayout(new FlowLayout());
        final var textField = new JTextField(20);
        final var label = new JLabel("Мітка");
        final var setButton = new JButton("Set");
        final var exitButton = new JButton("Exit");
        setButton.addActionListener(_ -> label.setText(textField.getText()));
        exitButton.addActionListener(_ -> dispose());
        add(new JLabel("Введіть текст: "));
        add(textField);
        add(label);
        add(setButton);
        add(exitButton);
    }
}
