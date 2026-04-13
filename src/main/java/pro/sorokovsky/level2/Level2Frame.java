package pro.sorokovsky.level2;

import pro.sorokovsky.common.helpers.SetupHelper;
import pro.sorokovsky.common.helpers.Transports;
import pro.sorokovsky.level2.model.Transport;

import javax.swing.*;
import java.awt.*;

public class Level2Frame extends JFrame {
    private final JPanel contentPanel = new JPanel();
    private final JButton refresh = new JButton("Оновити");

    public Level2Frame() throws HeadlessException {
        basicSetup();
        setupComponents();
    }

    private void basicSetup() {
        setTitle("Рівень 2");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        refresh.addActionListener(_ -> drawTransports());
        add(contentPanel);
        drawTransports();
    }

    private void setupComponents() {
        SetupHelper.setCreatingTransportMenu(this, new JMenuBar());
    }

    private void drawTransports() {
        contentPanel.removeAll();
        contentPanel.add(refresh);
        for (final var transport : Transports.transports) {
            drawTransport(transport);
        }
    }

    private void drawTransport(Transport transport) {
        final var textArea = new JTextArea(10, 10);
        textArea.setLineWrap(false);
        textArea.setText(transport.getInfo());
        final var scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPanel.add(scrollPane);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
