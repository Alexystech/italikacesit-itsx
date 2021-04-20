package com.itsx.italikacesit.view;

import javax.swing.*;

public class TypeOfWorkLayout extends JFrame{
    private JButton logoutLayoutButton;
    private JButton dashboardLayoutButton;
    private JButton vehiclesLayoutButton;
    private JButton mechanicsLayoutButton;
    private JButton clientLayoutButton;
    private JButton serviceManagerLayoutButton;
    private JTable table1;
    private JPanel typeOfWorkLayout;
    private JPanel navbarTypeOfWork;
    private JPanel panelOfTableTipeOfWork;

    public TypeOfWorkLayout() {
        setContentPane(typeOfWorkLayout);
        pack();
        setResizable(false);
    }
}
