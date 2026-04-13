package pro.sorokovsky.level2.handler;

import pro.sorokovsky.common.validation.ValidationException;
import pro.sorokovsky.level2.creator.CreateCarFrame;
import pro.sorokovsky.level2.creator.CreateExpressFrame;
import pro.sorokovsky.level2.creator.CreateTrainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTransportHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            getFrameFromType(actionEvent.getActionCommand()).setVisible(true);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private JFrame getFrameFromType(String type) throws ValidationException {
        return switch (type) {
            case "train" -> new CreateTrainFrame();
            case "express" -> new CreateExpressFrame();
            case "car" -> new CreateCarFrame();
            default -> throw new ValidationException("Невідомий тип");
        };
    }
}
