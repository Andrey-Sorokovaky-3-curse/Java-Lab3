package pro.sorokovsky.level3;

import pro.sorokovsky.common.validation.ValidationException;

import javax.swing.*;
import java.awt.*;

public class Level3Frame extends JFrame {
    private final JLabel error = new JLabel();
    private final JTextField countInput = new JTextField();
    private final ButtonGroup group = new ButtonGroup();
    private final JRadioButton oneArray = new JRadioButton("одновимірний");
    private final JRadioButton twoArray = new JRadioButton("двовимірний");
    private final JPanel arraysPanel = new JPanel();

    public Level3Frame() {
        setTitle("Рівень 3");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setupComponents();
    }

    private void setupComponents() {
        final var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        final var creationPanel = new JPanel();
        arraysPanel.setLayout(new BoxLayout(arraysPanel, BoxLayout.Y_AXIS));
        countInput.setColumns(15);
        creationPanel.setLayout(new FlowLayout());
        final var oneCountLabel = new JLabel("Введіть кількість елементів масиву: ");
        final var createOneArray = new JButton("Згенерувати масив");
        error.setForeground(Color.RED);
        createOneArray.addActionListener(_ -> createArray(countInput.getText()));
        creationPanel.add(oneCountLabel);
        creationPanel.add(countInput);
        group.add(oneArray);
        group.add(twoArray);
        creationPanel.add(oneArray);
        creationPanel.add(twoArray);
        creationPanel.add(error);
        creationPanel.add(createOneArray);
        panel.add(creationPanel);
        panel.add(arraysPanel);
        add(panel);
    }

    private void drawArray(Object array) {
        final var textArea = new JTextArea(10, 10);
        textArea.setLineWrap(false);
        textArea.setText(array.toString());
        final var scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        arraysPanel.add(scrollPane);
        arraysPanel.revalidate();
        arraysPanel.repaint();
    }

    private void createArray(String stringCount) {
        try {
            final var count = Integer.parseInt(stringCount);
            error.setText("");
            final var type = group.getSelection();
            if (type == null) {
                error.setText("Виберіть тип масиву");
            }
            if (type == oneArray.getModel()) {
                final var array = new OneArray(count);
                array.generate();
                drawArray(array);
            } else if (type == twoArray.getModel()) {
                final var array = new TwoArray(count);
                array.generate();
                drawArray(array);
            }
            group.clearSelection();
            countInput.setText("");
        } catch (NumberFormatException _) {
            error.setText("Ви ввели не число, пробуйте ввести число");
            countInput.requestFocus();
        }
        catch (ValidationException exception) {
            error.setText(exception.getMessage());
            countInput.requestFocus();
        }
    }
}
