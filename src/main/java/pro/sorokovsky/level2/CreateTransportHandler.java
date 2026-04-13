package pro.sorokovsky.level2;

import pro.sorokovsky.common.validation.ValidationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CreateTransportHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
    }

    private Map<String, JFrame> getFrameFromType(String type) throws ValidationException {
        if (type.equals("train")) {

        }
        if (type.equals("express")) {

        }
        if (type.equals("car")) {

        }
        throw new ValidationException("Невідомий тип");
    }
}
