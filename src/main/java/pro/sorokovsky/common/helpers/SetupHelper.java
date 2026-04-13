package pro.sorokovsky.common.helpers;

import pro.sorokovsky.level2.handler.CreateTransportHandler;

import javax.swing.*;

public class SetupHelper {
    public static void setCreatingTransportMenu(JFrame frame, JMenuBar menuBar) {
        final var transportMenu = new JMenu("Створити транспорт");
        final var createCar = new JMenuItem("Створити автомобіль");
        createCar.setActionCommand("car");
        createCar.addActionListener(new CreateTransportHandler());
        final var createTrain = new JMenuItem("Створити потяг");
        createTrain.addActionListener(new CreateTransportHandler());
        createTrain.setActionCommand("train");
        final var createExpress = new JMenuItem("Створити експрес");
        createExpress.setActionCommand("express");
        createExpress.addActionListener(new CreateTransportHandler());
        transportMenu.add(createCar);
        transportMenu.add(createTrain);
        transportMenu.add(createExpress);
        menuBar.add(transportMenu);
        frame.setJMenuBar(menuBar);
    }
}
