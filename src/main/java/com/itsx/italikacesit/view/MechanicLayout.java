package com.itsx.italikacesit.view;

import javax.swing.*;

public class MechanicLayout extends JFrame{
    private JTable table1;
    private JButton logoutLayoutButton;
    private JButton tWorkLayoutButton;
    private JButton vahiclesLayoutButton;
    private JButton dashboardLayoutButton;
    private JButton clientLayoutButton;
    private JButton serviceManagerLayoutButton;
    private JPanel mechanicLayout;
    private JPanel navbarMechanic;
    private JPanel panelOfTableMechanic;

    public MechanicLayout() {
        setContentPane(mechanicLayout);
        pack();
        setResizable(false);
    }
}
