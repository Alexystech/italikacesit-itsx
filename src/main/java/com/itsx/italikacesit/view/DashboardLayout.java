package com.itsx.italikacesit.view;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class DashboardLayout extends JFrame {
    private JTabbedPane paneDashboard;
    private JPanel graphSpace;
    private JPanel formWork;
    private JPanel formClient;
    private JPanel formMechanic;
    private JPanel formVehicle;
    private JPanel dashboardLayout;
    private JPanel navbarDashboard;
    private JPanel tabbedDashboard;
    private JComboBox typeServiceCBox;
    private JComboBox mechanicCBox;
    private JComboBox vehicleCBox;
    private JButton agregarServicioButton;
    private JTextField priceServiceField;
    private JTextField folioClientField;
    private JTextField nameClientField;
    private JTextField lastNameClientField;
    private JTextField motherLastNameClientField;
    private JButton agregarClienteButton;
    private JTextField celphoneClientField;
    private JTextPane issuesTPane;
    private JTextField folioMechanicField;
    private JTextField nameMechanicField;
    private JTextField lastNameMechanicField;
    private JTextField motherLastNameMechanicField;
    private JTextField specialityMechanicField;
    private JTextField cellphoneMechanicField;
    private JButton agregarMecanicoButton;
    private JComboBox clientCBox;
    private JTextField brandVehicleField;
    private JTextField modelVehicleField;
    private JTextField yearVehicleField;
    private JButton agregarVehiculoButton;
    private JPanel formTypeOfWork;
    private JTextField folioTWorkField;
    private JTextField nameTWorkField;
    private JButton agregarTipoDeTrabajoButton;
    private JButton logoutLayoutButton;
    private JButton typeWorkLayoutButton;
    private JButton vehiclesLayoutButton;
    private JButton machanicsLayoutButton;
    private JButton clientLayoutButton;
    private JButton serviceManagerLayoutButton;
    private JPanel paneDateRecive;
    private JPanel paneDateSend;
    private JTextField plaqueVehicleField;

    private JDateChooser dateRecive = new JDateChooser();
    private JDateChooser dateSend = new JDateChooser();

    public DashboardLayout() {
        setContentPane(dashboardLayout);
        setSize(1080,720);

        paneDateRecive.add(dateRecive);
        paneDateSend.add(dateSend);
    }
}
