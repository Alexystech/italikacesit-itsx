package com.itsx.italikacesit.validations.impl;

import com.itsx.italikacesit.validations.ClientValidations;

import javax.swing.*;

public class ClientValidationsImpl implements ClientValidations {

    public ClientValidationsImpl() {}

    @Override
    public void validateClientName(JTextField nameClientField, JLabel nameClientValidation) {
        if ( nameClientField.getText().trim().isEmpty() ) {
            nameClientValidation.setText("Debe llenar este campo");
        } else if ( nameClientField.getText().matches("[a-zA-Z ]+") ) {
            nameClientValidation.setText("");
        } else if ( nameClientField.getText().length() > 20 ) {
            nameClientValidation.setText("El nombre no puede tener mas de 20 caracteres");
        } else {
            nameClientValidation.setText("El nombre no puede contener caracteres especiales o numeros");
        }
    }

    @Override
    public void validateClientLastName(JTextField lastNameClientField, JLabel lastNameClientValidation) {
        if ( lastNameClientField.getText().trim().isEmpty() ) {
            lastNameClientValidation.setText("Debe llenar este campo");
        } else if ( lastNameClientField.getText().matches("[a-zA-Z ]+") ) {
            lastNameClientValidation.setText("");
        } else if ( lastNameClientField.getText().length() > 20 ) {
            lastNameClientValidation.setText("El apellido no puede tener mas de 20 caracteres");
        } else {
            lastNameClientValidation.setText("El apellido no puede contener caracteres especiales o numeros");
        }
    }

    @Override
    public void validateClientMotherLastName(JTextField motherLastNameClientField, JLabel motherLastNameClientValidation) {
        if ( motherLastNameClientField.getText().trim().isEmpty() ) {
            motherLastNameClientValidation.setText("Debe llenar este campo");
        } else if ( motherLastNameClientField.getText().matches("[a-zA-Z ]+") ) {
            motherLastNameClientValidation.setText("");
        } else if ( motherLastNameClientField.getText().length() > 20 ) {
            motherLastNameClientValidation.setText("El apellido materno no puede tener mas de 20 caracteres");
        } else {
            motherLastNameClientValidation.setText("El apellido materno no puede contener caracteres especiales o numeros");
        }
    }

    @Override
    public void validateClientCellphone(JTextField cellphoneClientField, JLabel cellphoneClientValidation) {
        if ( cellphoneClientField.getText().trim().isEmpty() ) {
            cellphoneClientValidation.setText("Debe llenar este campo");
        } else if ( !cellphoneClientField.getText().matches("[0-9]+") ) {
            cellphoneClientValidation.setText("Solo puede contener numeros");
        } else if ( cellphoneClientField.getText().length() > 10 || cellphoneClientField.getText().length() < 10) {
            cellphoneClientValidation.setText("El numero debe contener 10 digitos");
        } else if ( cellphoneClientField.getText().matches("[0-9]+") ) {
            cellphoneClientValidation.setText("");
        }  else {
            cellphoneClientValidation.setText("Dato erroneo");
        }
    }

}
