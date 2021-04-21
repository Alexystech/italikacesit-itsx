package com.itsx.italikacesit.controller;

import com.itsx.italikacesit.service.AdministratorService;
import com.itsx.italikacesit.service.ClientService;
import com.itsx.italikacesit.service.MechanicService;
import com.itsx.italikacesit.service.TypeOfWorkService;
import com.itsx.italikacesit.service.VehicleService;
import com.itsx.italikacesit.service.WorkService;
import com.itsx.italikacesit.service.impl.AdministratorServiceImpl;
import com.itsx.italikacesit.utility.ClientValidations;
import com.itsx.italikacesit.view.DashboardLayout;
import com.itsx.italikacesit.view.LoginLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DashboardController implements ActionListener {

    private DashboardLayout dashboardLayout;
    private ClientService clientService;
    private MechanicService mechanicService;
    private TypeOfWorkService typeOfWorkService;
    private VehicleService vehicleService;
    private WorkService workService;

    public DashboardController(DashboardLayout dashboardLayout, ClientService clientService
            , MechanicService mechanicService, TypeOfWorkService typeOfWorkService
            , VehicleService vehicleService, WorkService workService) {
        this.dashboardLayout = dashboardLayout;
        this.clientService = clientService;
        this.mechanicService = mechanicService;
        this.typeOfWorkService = typeOfWorkService;
        this.vehicleService = vehicleService;
        this.workService = workService;
        this.dashboardLayout.agregarServicioButton.addActionListener(this);
        this.dashboardLayout.agregarClienteButton.addActionListener(this);
        this.dashboardLayout.agregarMecanicoButton.addActionListener(this);
        this.dashboardLayout.agregarVehiculoButton.addActionListener(this);
        this.dashboardLayout.agregarTipoDeTrabajoButton.addActionListener(this);

        this.dashboardLayout.serviceManagerLayoutButton.addActionListener(this);
        this.dashboardLayout.clientLayoutButton.addActionListener(this);
        this.dashboardLayout.machanicsLayoutButton.addActionListener(this);
        this.dashboardLayout.vehiclesLayoutButton.addActionListener(this);
        this.dashboardLayout.typeWorkLayoutButton.addActionListener(this);
        this.dashboardLayout.logoutLayoutButton.addActionListener(this);
    }

    public void start() {
        dashboardLayout.setTitle("ITALIKA CESIT DashboardManagement");
        dashboardLayout.setLocationRelativeTo(null);
        dashboardLayout.setVisible(true);
        dashboardLayout.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void runValidations() {
        dashboardLayout.nameClientField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                ClientValidations clientValidations = new ClientValidations();
                clientValidations.validateClientName(dashboardLayout.nameClientField, dashboardLayout.nameClientValidation);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == dashboardLayout.logoutLayoutButton ) {
            dashboardLayout.setVisible(false);

            LoginLayout loginLayout = new LoginLayout();
            AdministratorService administratorService = new AdministratorServiceImpl();
            LoginController loginController = new LoginController(loginLayout, administratorService);

            loginController.start();
            loginController.runValidations();
        }
    }

}
