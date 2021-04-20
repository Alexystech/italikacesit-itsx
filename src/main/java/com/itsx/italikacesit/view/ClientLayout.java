package com.itsx.italikacesit.view;

import javax.swing.*;

public class ClientLayout extends JFrame{

    private JTable table1;
    private JButton logoutLayoutButton;
    private JButton tWorkLayoutButton;
    private JButton vehiclesLayoutButton;
    private JButton mechanicsLayoutButton;
    private JButton dashboardLayoutButton;
    private JButton serviceManagerLayoutButton;
    private JPanel clientLayout;
    private JPanel paneOfTableClient;

    public ClientLayout() {
        setContentPane(clientLayout);
        pack();
        setResizable(false);
    }
}
