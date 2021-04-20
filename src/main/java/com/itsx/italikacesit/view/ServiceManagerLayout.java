package com.itsx.italikacesit.view;

import javax.swing.*;

public class ServiceManagerLayout extends JFrame{
    private JButton logoutLayoutButton;
    private JButton tWorkLayoutButton;
    private JButton vahiclesLayoutButton;
    private JButton machanicsLayoutButton;
    private JButton clientLayoutButton;
    private JButton dashboardLayoutButton;
    private JTable tableServiceManager;
    private JPanel serviceManagerLayout;
    private JPanel panelOfTableServiceManager;
    private JPanel navbarServiceManager;

    public ServiceManagerLayout() {
        setContentPane(serviceManagerLayout);
        pack();
        setResizable(false);
    }
}
