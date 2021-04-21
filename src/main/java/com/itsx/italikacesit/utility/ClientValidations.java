package com.itsx.italikacesit.utility;

import javax.swing.*;

public class ClientValidations {

    public ClientValidations() {}

    public void validateClientName(JTextField nameClientField, JLabel nameClientValidation) {
        if ( nameClientField.getText().trim().isEmpty() ) {
            nameClientValidation.setText("Debe llenar este campo");
        } else if ( nameClientField.getText().matches("[a-zA-Z ]+") ) {
            nameClientValidation.setText("");
        } else {
            nameClientValidation.setText("El nombre no puede contener caracteres especiales o numeros");
        }
    }
}
