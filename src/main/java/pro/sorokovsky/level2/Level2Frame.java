package pro.sorokovsky.level2;

import javax.swing.*;
import java.awt.*;

public class Level2Frame extends JFrame {
    public Level2Frame() throws HeadlessException {
        basicSetup();
        setupComponents();
    }

    private void basicSetup() {
        setTitle("Рівень 2");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
    }

    private void setupComponents() {
        setupMenu();
    }

    private void setupMenu() {
        final var menu = new JMenuBar();
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
        menu.add(transportMenu);
        setJMenuBar(menu);
    }
}
