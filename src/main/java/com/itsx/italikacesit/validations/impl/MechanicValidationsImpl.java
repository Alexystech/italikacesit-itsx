package com.itsx.italikacesit.validations.impl;

import com.itsx.italikacesit.validations.MechanicValidations;

import javax.swing.*;

public class MechanicValidationsImpl implements MechanicValidations {

    public MechanicValidationsImpl() {}

    @Override
    public void validateMechanicName(JTextField nameMechanicField, JLabel nameMechanicValidation) {
        if ( nameMechanicField.getText().trim().isEmpty() ) {
            nameMechanicValidation.setText("Debe llenar este campo");
        } else if ( nameMechanicField.getText().matches("[a-zA-Z ]+") ) {
            nameMechanicValidation.setText("");
        } else if ( nameMechanicField.getText().length() > 20 ) {
            nameMechanicValidation.setText("El nombre no puede tener mas de 20 caracteres");
        } else {
            nameMechanicValidation.setText("El nombre no puede contener caracteres especiales o numeros");
        }
    }

    @Override
    public void validateMechanicLastName(JTextField lastNameMechanicField, JLabel lastNameMechanicValidation) {
        if ( lastNameMechanicField.getText().trim().isEmpty() ) {
            lastNameMechanicValidation.setText("Debe llenar este campo");
        } else if ( lastNameMechanicField.getText().matches("[a-zA-Z ]+") ) {
            lastNameMechanicValidation.setText("");
        } else if ( lastNameMechanicField.getText().length() > 20 ) {
            lastNameMechanicValidation.setText("El apellido no puede tener mas de 20 caracteres");
        } else {
            lastNameMechanicValidation.setText("El paellido no puede contener caracteres especiales o numeros");
        }
    }

    @Override
    public void validateMechanicMotherLastName(JTextField motherLastNameMechanicField, JLabel motherLastNameMechanicValidation) {
        if ( motherLastNameMechanicField.getText().trim().isEmpty() ) {
            motherLastNameMechanicValidation.setText("Debe llenar este campo");
        } else if ( motherLastNameMechanicField.getText().matches("[a-zA-Z ]+") ) {
            motherLastNameMechanicValidation.setText("");
        } else if ( motherLastNameMechanicField.getText().length() > 20 ) {
            motherLastNameMechanicValidation.setText("El apellido materno no puede tener mas de 20 caracteres");
        } else {
            motherLastNameMechanicValidation.setText("El apellido materno no puede contener caracteres especiales o numeros");
        }
    }

    @Override
    public void validateMechanicSpeciality(JTextField specialityMechanicField, JLabel specialityMechanicValidation) {
        if ( specialityMechanicField.getText().trim().isEmpty() ) {
            specialityMechanicValidation.setText("Debe llenar este campo");
        } else if ( specialityMechanicField.getText().matches("[a-zA-Z ]+") ) {
            specialityMechanicValidation.setText("");
        } else if ( specialityMechanicField.getText().length() > 20 ) {
            specialityMechanicValidation.setText("La especialidad no puede tener mas de 20 caracteres");
        } else {
            specialityMechanicValidation.setText("La especialidad no puede contener caracteres especiales o numeros");
        }
    }

    @Override
    public void validateMechanicCellphone(JTextField cellphoneMechanicField, JLabel cellphoneMechanicValidation) {
        if ( cellphoneMechanicField.getText().trim().isEmpty() ) {
            cellphoneMechanicValidation.setText("Debe llenar este campo");
        } else if ( !cellphoneMechanicField.getText().matches("[0-9]+") ) {
            cellphoneMechanicValidation.setText("Solo puede contener numeros");
        } else if ( cellphoneMechanicField.getText().length() > 10 || cellphoneMechanicField.getText().length() < 10) {
            cellphoneMechanicValidation.setText("El numero debe contener 10 digitos");
        } else if ( cellphoneMechanicField.getText().matches("[0-9]+") ) {
            cellphoneMechanicValidation.setText("");
        }  else {
            cellphoneMechanicValidation.setText("Dato erroneo");
        }
    }
}
