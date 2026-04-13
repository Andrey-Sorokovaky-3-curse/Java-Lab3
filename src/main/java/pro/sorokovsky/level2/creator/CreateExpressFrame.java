package pro.sorokovsky.level2.creator;

import pro.sorokovsky.common.helpers.Transports;
import pro.sorokovsky.common.validation.MarkException;
import pro.sorokovsky.common.validation.ValidationException;
import pro.sorokovsky.level2.model.Express;
import pro.sorokovsky.level2.model.Transport;

import javax.swing.*;
import java.awt.*;

public class CreateExpressFrame extends JFrame {
    private final JLabel nameError = new JLabel();
    private final JTextField nameField = new JTextField();

    private final JLabel markError = new JLabel();
    private final JTextField markField = new JTextField();

    public CreateExpressFrame() {
        setTitle("Створити експесс");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setupControllers();
    }

    private void setupControllers() {
        final var panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nameError.setForeground(Color.RED);
        panel.add(new JLabel("Введіть назву експресу:"));
        nameField.setColumns(15);
        panel.add(nameField);
        panel.add(nameError);
        markError.setForeground(Color.RED);
        panel.add(new JLabel("Введіть марку експресу: "));
        markField.setColumns(15);
        panel.add(markField);
        panel.add(markError);
        final var button = new JButton("Створити");
        button.addActionListener(_ -> create());
        panel.add(button);
        add(panel);
    }

    private void create() {
        try {
            nameError.setText("");
            markError.setText("");
            Transports.transports.add(new Express(nameField.getText(), markField.getText()));
            dispose();
        } catch (MarkException markException) {
            markError.setText(markException.getMessage());
            markField.requestFocus();
        }
        catch (ValidationException exception) {
            nameError.setText(exception.getMessage());
            nameField.requestFocus();
        }
    }
}
