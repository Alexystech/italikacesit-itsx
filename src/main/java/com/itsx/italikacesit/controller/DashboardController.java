package com.itsx.italikacesit.controller;

import com.itsx.italikacesit.service.AdministratorService;
import com.itsx.italikacesit.service.ClientService;
import com.itsx.italikacesit.service.MechanicService;
import com.itsx.italikacesit.service.TypeOfWorkService;
import com.itsx.italikacesit.service.VehicleService;
import com.itsx.italikacesit.service.WorkService;
import com.itsx.italikacesit.service.impl.AdministratorServiceImpl;
import com.itsx.italikacesit.service.impl.TypeOfWorkServiceImpl;
import com.itsx.italikacesit.validations.ClientValidations;
import com.itsx.italikacesit.validations.MechanicValidations;
import com.itsx.italikacesit.validations.TypeOfWorkValidations;
import com.itsx.italikacesit.validations.VehicleValidations;
import com.itsx.italikacesit.validations.WorkValidations;
import com.itsx.italikacesit.validations.impl.ClientValidationsImpl;
import com.itsx.italikacesit.validations.impl.MechanicValidationsImpl;
import com.itsx.italikacesit.validations.impl.TypeOfWorkValidationsImpl;
import com.itsx.italikacesit.validations.impl.VehicleValidationsImpl;
import com.itsx.italikacesit.validations.impl.WorkValidationsImpl;
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
                ClientValidations clientValidations = new ClientValidationsImpl();
                clientValidations.validateClientName(dashboardLayout.nameClientField
                        , dashboardLayout.nameClientValidation);
            }
        });

        dashboardLayout.lastNameClientField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                ClientValidations clientValidations = new ClientValidationsImpl();
                clientValidations.validateClientLastName(dashboardLayout.lastNameClientField
                        , dashboardLayout.lastNameClientValidation);
            }
        });

        dashboardLayout.motherLastNameClientField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                ClientValidations clientValidations = new ClientValidationsImpl();
                clientValidations.validateClientMotherLastName(dashboardLayout.motherLastNameClientField
                        , dashboardLayout.motherLastNameClientValidation);
            }
        });

        dashboardLayout.cellphoneClientField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                ClientValidations clientValidations = new ClientValidationsImpl();
                clientValidations.validateClientCellphone(dashboardLayout.cellphoneClientField
                        , dashboardLayout.cellphoneClientValidation);
            }
        });

        dashboardLayout.nameMechanicField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                MechanicValidations mechanicValidations = new MechanicValidationsImpl();
                mechanicValidations.validateMechanicName(dashboardLayout.nameMechanicField
                        , dashboardLayout.nameMechanicValidation);
            }
        });

        dashboardLayout.lastNameMechanicField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                MechanicValidations mechanicValidations = new MechanicValidationsImpl();
                mechanicValidations.validateMechanicLastName(dashboardLayout.lastNameMechanicField
                        , dashboardLayout.lastNameMechanicValidation);
            }
        });

        dashboardLayout.motherLastNameMechanicField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                MechanicValidations mechanicValidations = new MechanicValidationsImpl();
                mechanicValidations.validateMechanicMotherLastName(dashboardLayout.motherLastNameMechanicField
                        , dashboardLayout.motherLastNameMechanicValidation);
            }
        });

        dashboardLayout.specialityMechanicField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                MechanicValidations mechanicValidations = new MechanicValidationsImpl();
                mechanicValidations.validateMechanicSpeciality(dashboardLayout.specialityMechanicField
                        , dashboardLayout.specialityMechanicValidation);
            }
        });

        dashboardLayout.cellphoneMechanicField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                MechanicValidations mechanicValidations = new MechanicValidationsImpl();
                mechanicValidations.validateMechanicCellphone(dashboardLayout.cellphoneMechanicField
                        , dashboardLayout.cellphoneMechanicValidation);
            }
        });

        dashboardLayout.plaqueVehicleField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                VehicleValidations vehicleValidations = new VehicleValidationsImpl();
                vehicleValidations.validatePlaqueVehicle(dashboardLayout.plaqueVehicleField
                        , dashboardLayout.plaqueVehicleValidation);
            }
        });

        dashboardLayout.brandVehicleField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                VehicleValidations vehicleValidations = new VehicleValidationsImpl();
                vehicleValidations.validateBrandVehicle(dashboardLayout.brandVehicleField
                        , dashboardLayout.brandVehicleValidation);
            }
        });

        dashboardLayout.modelVehicleField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                VehicleValidations vehicleValidations = new VehicleValidationsImpl();
                vehicleValidations.validateModelVehicle(dashboardLayout.modelVehicleField
                        , dashboardLayout.modelVehicleValidation);
            }
        });

        dashboardLayout.yearVehicleCBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                VehicleValidations vehicleValidations = new VehicleValidationsImpl();
                vehicleValidations.validateYearVehicle(dashboardLayout.yearVehicleCBox
                        , dashboardLayout.yearVehicleValidation);
            }
        });

        dashboardLayout.nameTWorkField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                TypeOfWorkValidations typeOfWorkValidations = new TypeOfWorkValidationsImpl();
                typeOfWorkValidations.validateNameTypeOfWork(dashboardLayout.nameTWorkField
                        , dashboardLayout.nameTWorkValidation);
            }
        });

        dashboardLayout.typeServiceCBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                WorkValidations workValidations = new WorkValidationsImpl();
                workValidations.validateTypeServiceWork(dashboardLayout.typeServiceCBox
                        , dashboardLayout.typeServiceWorkValidation);
            }
        });

        dashboardLayout.mechanicCBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                WorkValidations workValidations = new WorkValidationsImpl();
                workValidations.validateMechanicWork(dashboardLayout.mechanicCBox
                        , dashboardLayout.mechanicWorkValidation);
            }
        });

        dashboardLayout.vehicleCBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                WorkValidations workValidations = new WorkValidationsImpl();
                workValidations.validateVehicleWork(dashboardLayout.vehicleCBox
                        , dashboardLayout.vehicleWorkValidation);
            }
        });

        dashboardLayout.priceServiceField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                WorkValidations workValidations = new WorkValidationsImpl();
                workValidations.validatePriceWork(dashboardLayout.priceServiceField
                        , dashboardLayout.priceWorkValidation);
            }
        });

        dashboardLayout.dateReceive.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                WorkValidations workValidations = new WorkValidationsImpl();
                workValidations.validateDateReceiveWork(dashboardLayout.dateReceive
                        , dashboardLayout.dateReceiveWorkValidation);
            }
        });

        dashboardLayout.dateSend.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                WorkValidations workValidations = new WorkValidationsImpl();
                workValidations.validateDateSendWork(dashboardLayout.dateSend
                        , dashboardLayout.dateSendWorkValidation);
            }
        });

        dashboardLayout.clientCBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                WorkValidations workValidations = new WorkValidationsImpl();
                workValidations.validateClientWork(dashboardLayout.clientCBox
                        , dashboardLayout.clientWorkValidation);
            }
        });

        dashboardLayout.issuesTPane.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                WorkValidations workValidations = new WorkValidationsImpl();
                workValidations.validateIssuesWork(dashboardLayout.issuesTPane
                        , dashboardLayout.issuesWorkValidation);
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
