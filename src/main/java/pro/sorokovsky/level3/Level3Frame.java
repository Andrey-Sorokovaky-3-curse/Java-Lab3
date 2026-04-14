package pro.sorokovsky.level3;

import javax.swing.*;
import java.awt.*;

public class Level3Frame extends JFrame {
    public Level3Frame() {
        setTitle("Рівень 3");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setupComponents();
    }

    private void setupComponents() {
        final var panel = new JPanel();
        panel.setLayout(new FlowLayout());
        final var label = new JLabel("Введіть кількість елементів одновимірного масиву: ");
        final var input = new JTextField(10);
        final var createOneArray = new JButton("Створити одновимірний масив");
        panel.add(label);
        panel.add(input);
        panel.add(createOneArray);
        add(panel);
    }
}
