package com.itsx.italikacesit.validations.impl;

import com.itsx.italikacesit.validations.VehicleValidations;

import javax.swing.*;

public class VehicleValidationsImpl implements VehicleValidations {

    public VehicleValidationsImpl() {}

    @Override
    public void validatePlaqueVehicle(JTextField plaqueVehicleField, JLabel plaqueVehicleValidation) {
        if ( plaqueVehicleField.getText().trim().isEmpty() ) {
            plaqueVehicleValidation.setText("Debe llenar este campo");
        } else if ( plaqueVehicleField.getText().length() > 7 || plaqueVehicleField.getText().length() < 7 ) {
            plaqueVehicleValidation.setText("La placa debe contener 7 dijitos");
        } else if ( !plaqueVehicleField.getText().matches("[a-zA-Z]{3}[0-9]{3}[a-zA-Z0-9]") ) {
            plaqueVehicleValidation.setText("Placa invalida");
        } else {
            plaqueVehicleValidation.setText("");
        }
    }

    @Override
    public void validateBrandVehicle(JTextField brandVehicleField, JLabel brandVehicleValidation) {
        if ( brandVehicleField.getText().trim().isEmpty() ) {
            brandVehicleValidation.setText("Debe llenar este campo");
        } else if ( brandVehicleField.getText().matches("[a-zA-Z ]+") ) {
            brandVehicleValidation.setText("");
        } else if ( brandVehicleField.getText().length() > 20 ) {
            brandVehicleValidation.setText("La marca no puede tener mas de 20 caracteres");
        } else {
            brandVehicleValidation.setText("La marca no puede contener caracteres especiales o numeros");
        }
    }

    @Override
    public void validateModelVehicle(JTextField modelVehicleField, JLabel modelVehicleValidation) {
        if ( modelVehicleField.getText().trim().isEmpty() ) {
            modelVehicleValidation.setText("Debe llenar este campo");
        } else if ( modelVehicleField.getText().matches("[a-zA-Z0-9 ]+") ) {
            modelVehicleValidation.setText("");
        } else if ( modelVehicleField.getText().length() > 20 ) {
            modelVehicleValidation.setText("La marca no puede tener mas de 20 caracteres");
        } else {
            modelVehicleValidation.setText("La marca no puede contener caracteres especiales");
        }
    }

    @Override
    public void validateYearVehicle(JComboBox yearVehicleCBox, JLabel yearVehicleValidation) {
        if ( yearVehicleCBox.getSelectedItem().toString().isEmpty() ) {
            yearVehicleValidation.setText("Seleccione un año");
        } else {
            yearVehicleValidation.setText("");
        }
    }
}
