package pro.sorokovsky.level2.creator;

import pro.sorokovsky.common.helpers.Transports;
import pro.sorokovsky.common.validation.ValidationException;
import pro.sorokovsky.level2.model.Train;

import javax.swing.*;
import java.awt.*;

public class CreateTrainFrame extends JFrame {
    private final JLabel error = new JLabel();
    private final JTextField inputField = new JTextField();

    public CreateTrainFrame() {
        setTitle("Створити потяг");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setupControllers();
    }

    private void setupControllers() {
        final var panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        error.setForeground(Color.RED);
        final var label = new JLabel("Назву потягу: ");
        inputField.setColumns(15);
        final var button = new JButton("Створити");
        button.addActionListener(_ -> create());
        panel.add(label);
        panel.add(inputField);
        panel.add(error);
        panel.add(button);
        add(panel);
    }

    private void create() {
        try {
            error.setText("");
            Transports.transports.add(new Train(inputField.getText()));
            dispose();
        } catch (ValidationException exception) {
            error.setText(exception.getMessage());
            inputField.requestFocus();
        }
    }
}
