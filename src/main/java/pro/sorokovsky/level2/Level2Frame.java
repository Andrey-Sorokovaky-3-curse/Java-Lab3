package pro.sorokovsky.level2;

import pro.sorokovsky.common.helpers.SetupHelper;
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
        SetupHelper.setCreatingTransportMenu(this, new JMenuBar());
    }
}
