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
    public JTextField cellphoneClientField;
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
    private JPanel paneDateReceive;
    private JPanel paneDateSend;
    public JTextField plaqueVehicleField;
    public JLabel nameClientValidation;
    public JLabel lastNameClientValidation;
    public JLabel motherLastNameClientValidation;
    public JLabel cellphoneClientValidation;
    public JLabel folioClientValidation;
    public JLabel nameMechanicValidation;
    public JLabel lastNameMechanicValidation;
    public JLabel motherLastNameMechanicValidation;
    public JLabel specialityMechanicValidation;
    public JLabel cellphoneMechanicValidation;
    public JLabel plaqueVehicleValidation;
    public JLabel brandVehicleValidation;
    public JLabel modelVehicleValidation;
    public JLabel yearVehicleValidation;
    public JComboBox yearVehicleCBox;
    public JLabel folioMechanicValidation;
    public JTextField folioServiceField;
    public JLabel folioTWorkValidation;
    public JLabel nameTWorkValidation;
    public JLabel typeServiceWorkValidation;
    public JLabel mechanicWorkValidation;
    public JLabel vehicleWorkValidation;
    public JLabel priceWorkValidation;
    public JLabel dateReceiveWorkValidation;
    public JLabel dateSendWorkValidation;
    public JLabel clientWorkValidation;
    public JLabel issuesWorkValidation;

    public JDateChooser dateReceive = new JDateChooser();
    public JDateChooser dateSend = new JDateChooser();

    public DashboardLayout() {
        setContentPane(dashboardLayout);
        setSize(1080,720);

        dateReceive.setDateFormatString("yyyy/MM/dd HH:mm:ss");
        dateSend.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        paneDateReceive.add(dateReceive);
        paneDateSend.add(dateSend);
    }
}
