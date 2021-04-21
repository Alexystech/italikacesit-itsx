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
    public JComboBox typeServiceCBox;
    public JComboBox mechanicCBox;
    public JComboBox vehicleCBox;
    public JButton agregarServicioButton;
    public JTextField priceServiceField;
    public JTextField folioClientField;
    public JTextField nameClientField;
    public JTextField lastNameClientField;
    public JTextField motherLastNameClientField;
    public JButton agregarClienteButton;
    public JTextField celphoneClientField;
    public JTextPane issuesTPane;
    public JTextField folioMechanicField;
    public JTextField nameMechanicField;
    public JTextField lastNameMechanicField;
    public JTextField motherLastNameMechanicField;
    public JTextField specialityMechanicField;
    public JTextField cellphoneMechanicField;
    public JButton agregarMecanicoButton;
    public JComboBox clientCBox;
    public JTextField brandVehicleField;
    public JTextField modelVehicleField;
    public JTextField yearVehicleField;
    public JButton agregarVehiculoButton;
    private JPanel formTypeOfWork;
    public JTextField folioTWorkField;
    public JTextField nameTWorkField;
    public JButton agregarTipoDeTrabajoButton;
    public JButton logoutLayoutButton;
    public JButton typeWorkLayoutButton;
    public JButton vehiclesLayoutButton;
    public JButton machanicsLayoutButton;
    public JButton clientLayoutButton;
    public JButton serviceManagerLayoutButton;
    private JPanel paneDateRecive;
    private JPanel paneDateSend;
    public JTextField plaqueVehicleField;
    public JLabel nameClientValidation;
    public JLabel lastNameClientValidation;
    public JLabel motherLastNameClientValidation;
    public JLabel cellphoneClientValidation;
    private JLabel folioClientValidation;

    public JDateChooser dateRecive = new JDateChooser();
    public JDateChooser dateSend = new JDateChooser();

    public DashboardLayout() {
        setContentPane(dashboardLayout);
        setSize(1080,720);

        paneDateRecive.add(dateRecive);
        paneDateSend.add(dateSend);
    }
}
