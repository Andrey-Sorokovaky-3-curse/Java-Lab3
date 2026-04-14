package pro.sorokovsky.level3;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Level3Frame extends JFrame {
    private final LinkedList<OneArray> oneArrays = new LinkedList<>();
    private final JLabel oneError = new JLabel();
    private final JTextField oneInput = new JTextField();

    public Level3Frame() {
        setTitle("Рівень 3");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setupComponents();
    }

    private void setupComponents() {
        final var panel = new JPanel();
        panel.setLayout(new FlowLayout());
        final var oneCountLabel = new JLabel("Введіть кількість елементів одновимірного масиву: ");
        final var createOneArray = new JButton("Створити одновимірний масив");
        createOneArray.addActionListener(_ -> createOneArray(oneInput.getText()));
        panel.add(oneCountLabel);
        panel.add(oneInput);
        panel.add(createOneArray);
        add(panel);
    }

    private void createOneArray(String stringCount) {
        try {
            final var count = Integer.parseInt(stringCount);
            oneError.setText("");
            oneArrays.add(new OneArray(count));
        } catch (NumberFormatException _) {
            oneError.setText("Ви ввели не число, пробуйте ввести число");
            oneInput.requestFocus();
        }
    }
}
