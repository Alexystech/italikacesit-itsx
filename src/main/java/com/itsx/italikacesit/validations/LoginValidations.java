package com.itsx.italikacesit.validations;

import javax.swing.*;

public interface LoginValidations {
    void validateLoginUserName(JTextField userNameLoginField, JLabel userNameLoginValidation);
    void validateLoginPassword(JPasswordField passwordLoginField, JLabel passwordLoginValidation);
}
