package com.itsx.italikacesit.utility;

import javax.swing.*;
import java.util.Arrays;

public class LoginValidations {

    public LoginValidations() {}

    public void validateLoginUserName(JTextField userNameLoginField, JLabel userNameLoginValidation) {
        if ( userNameLoginField.getText().trim().isEmpty() ) {
            userNameLoginValidation.setText("Dabe llenar este campo");
        } else {
            userNameLoginValidation.setText("");
        }
    }

    public void validateLoginPassword(JPasswordField passwordLoginField, JLabel passwordLoginValidation) {
        char[] x = new char[0];
        if (Arrays.equals(passwordLoginField.getPassword(), x) ) {
            passwordLoginValidation.setText("Debe llenar este campo");
        } else {
            passwordLoginValidation.setText("");
        }
    }
}
