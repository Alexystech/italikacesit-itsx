package com.itsx.italikacesit.validations.impl;

import com.itsx.italikacesit.validations.TypeOfWorkValidations;

import javax.swing.*;

public class TypeOfWorkValidationsImpl implements TypeOfWorkValidations {

    public TypeOfWorkValidationsImpl() {}

    @Override
    public void validateNameTypeOfWork(JTextField nameTWorkField, JLabel nameTWorkValidation) {
        if ( nameTWorkField.getText().trim().isEmpty() ) {
            nameTWorkValidation.setText("Debe llenar este campo");
        } else if ( nameTWorkField.getText().matches("[a-zA-Z ]+") ) {
            nameTWorkValidation.setText("");
        } else if ( nameTWorkField.getText().length() > 30 ) {
            nameTWorkValidation.setText("El nombre no puede tener mas de 30 caracteres");
        } else {
            nameTWorkValidation.setText("El nombre no puede contener caracteres especiales o numeros");
        }
    }
}
