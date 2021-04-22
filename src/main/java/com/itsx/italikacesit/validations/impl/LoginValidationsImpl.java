package com.itsx.italikacesit.validations.impl;

import com.itsx.italikacesit.validations.LoginValidations;

import javax.swing.*;
import java.util.Arrays;

public class LoginValidationsImpl implements LoginValidations {

    public LoginValidationsImpl() {}

    @Override
    public void validateLoginUserName(JTextField userNameLoginField, JLabel userNameLoginValidation) {
        if ( userNameLoginField.getText().trim().isEmpty() ) {
            userNameLoginValidation.setText("Dabe llenar este campo");
        } else {
            userNameLoginValidation.setText("");
        }
    }

    @Override
    public void validateLoginPassword(JPasswordField passwordLoginField, JLabel passwordLoginValidation) {
        char[] x = new char[0];
        if (Arrays.equals(passwordLoginField.getPassword(), x) ) {
            passwordLoginValidation.setText("Debe llenar este campo");
        } else {
            passwordLoginValidation.setText("");
        }
    }
}
