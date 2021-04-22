package com.itsx.italikacesit.controller;

import com.itsx.italikacesit.model.Administrator;
import com.itsx.italikacesit.service.AdministratorService;
import com.itsx.italikacesit.service.ClientService;
import com.itsx.italikacesit.service.MechanicService;
import com.itsx.italikacesit.service.TypeOfWorkService;
import com.itsx.italikacesit.service.VehicleService;
import com.itsx.italikacesit.service.WorkService;
import com.itsx.italikacesit.service.impl.ClientServiceImpl;
import com.itsx.italikacesit.service.impl.MechanicServiceImpl;
import com.itsx.italikacesit.service.impl.TypeOfWorkServiceImpl;
import com.itsx.italikacesit.service.impl.VehicleServiceImpl;
import com.itsx.italikacesit.service.impl.WorkServiceImpl;
import com.itsx.italikacesit.validations.impl.LoginValidationsImpl;
import com.itsx.italikacesit.view.DashboardLayout;
import com.itsx.italikacesit.view.LoginLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.util.List;

public class LoginController implements ActionListener {

    private LoginLayout loginLayout;
    private AdministratorService administratorService;

    public LoginController(LoginLayout loginLayout, AdministratorService administratorService) {
        this.loginLayout = loginLayout;
        this.administratorService = administratorService;
        this.loginLayout.loginButton.addActionListener(this);
    }

    public void start() {
        loginLayout.setTitle("Sign in");
        loginLayout.setLocationRelativeTo(null);
        loginLayout.setVisible(true);
        loginLayout.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void runValidations() {
        loginLayout.loginField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                LoginValidationsImpl loginValidationsImpl = new LoginValidationsImpl();
                loginValidationsImpl.validateLoginUserName(loginLayout.loginField,loginLayout.userNameLoginValidation);
            }
        });

        loginLayout.passwordLoginField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                LoginValidationsImpl loginValidationsImpl = new LoginValidationsImpl();
                loginValidationsImpl.validateLoginPassword(loginLayout.passwordLoginField
                        , loginLayout.passwordLoginValidation);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == loginLayout.loginButton ) {
            List<Administrator> administrators = administratorService.getAllAdministrators();

            if ( loginValidation(administrators) ) {
                loginLayout.setVisible(false);

                DashboardLayout dashboardLayout = new DashboardLayout();

                ClientService clientService = new ClientServiceImpl();
                MechanicService mechanicService = new MechanicServiceImpl();
                TypeOfWorkService typeOfWorkService = new TypeOfWorkServiceImpl();
                VehicleService vehicleService = new VehicleServiceImpl();
                WorkService workService = new WorkServiceImpl();

                DashboardController dashboardController = new DashboardController(
                        dashboardLayout, clientService, mechanicService, typeOfWorkService
                        , vehicleService, workService
                );

                dashboardController.start();
                dashboardController.runValidations();
            } else {
                loginLayout.loginField.setText("");
                loginLayout.passwordLoginField.setText("");
                loginLayout.formLoginValidation.setText("Usuario o contraseña no coinciden");
            }
        }

    }

    private boolean loginValidation(List<Administrator> administrators) {
        return administrators.stream()
                .anyMatch(administrator -> administrator.getUserName()
                        .equals(loginLayout.loginField.getText()) && Arrays.equals(administrator
                        .getPassword().toCharArray(), loginLayout.passwordLoginField.getPassword())
                );
    }

}
