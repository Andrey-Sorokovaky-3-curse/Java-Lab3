package pro.sorokovsky.level2.creator;

import pro.sorokovsky.common.helpers.Transports;
import pro.sorokovsky.common.validation.ValidationException;
import pro.sorokovsky.level2.model.Car;
import pro.sorokovsky.level2.model.Transport;

import javax.swing.*;
import java.awt.*;

public class CreateCarFrame extends JFrame {
    private final JTextField inputField = new JTextField();
    private final JLabel error = new JLabel("");

    public CreateCarFrame() {
        setTitle("Створити автомобіль");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setupControllers();
    }

    private void setupControllers() {
        final var panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        error.setForeground(Color.RED);
        final var label = new JLabel("Введіть максимальний розмір баку у літрах: ");
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
            final var maxFull = Long.parseLong(inputField.getText());
            error.setText("");
            Transports.transports.add(new Car(maxFull));
            dispose();
        } catch (ValidationException exception) {
            error.setText(exception.getMessage());
            inputField.requestFocus();
        } catch (NumberFormatException exception) {
            error.setText("Ви ввели не число.");
            inputField.requestFocus();
        }
    }
}
