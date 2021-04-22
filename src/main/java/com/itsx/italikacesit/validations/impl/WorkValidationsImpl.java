package com.itsx.italikacesit.validations.impl;

import com.itsx.italikacesit.validations.WorkValidations;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public class WorkValidationsImpl implements WorkValidations {

    public WorkValidationsImpl() {}

    @Override
    public void validateTypeServiceWork(JComboBox typeServiceCBox, JLabel typeServiceWorkValidation) {
        if ( typeServiceCBox.getSelectedItem().toString().isEmpty() ) {
            typeServiceWorkValidation.setText("Seleccione un servicio");
        } else {
            typeServiceWorkValidation.setText("");
        }
    }

    @Override
    public void validateMechanicWork(JComboBox mechanicCBox, JLabel mechanicWorkValidation) {
        if ( mechanicCBox.getSelectedItem().toString().isEmpty() ) {
            mechanicWorkValidation.setText("Seleccione un servicio");
        } else {
            mechanicWorkValidation.setText("");
        }
    }

    @Override
    public void validateVehicleWork(JComboBox vehicleCBox, JLabel vehicleWorkValidation) {
        if ( vehicleCBox.getSelectedItem().toString().isEmpty() ) {
            vehicleWorkValidation.setText("Seleccione un servicio");
        } else {
            vehicleWorkValidation.setText("");
        }
    }

    @Override
    public void validatePriceWork(JTextField priceServiceField, JLabel priceWorkValidation) {
        if ( priceServiceField.getText().isEmpty() ) {
            priceWorkValidation.setText("Debe llenar este campo");
        } else if ( !priceServiceField.getText().matches("[0-9]+.[0-9]+|[0-9]+") ) {
            priceWorkValidation.setText("Se debe ingresar un numero");
        } else {
            priceWorkValidation.setText("");
        }
    }

    @Override
    public void validateDateReceiveWork(JDateChooser dateReceive, JLabel dateReceiveWorkValidation) {
        if ( dateReceive.getDate().toString().isEmpty() ) {
            dateReceiveWorkValidation.setText("Debe llenar este campo");
        } else {
            dateReceiveWorkValidation.setText("");
        }
    }

    @Override
    public void validateDateSendWork(JDateChooser dateSend, JLabel dateSendWorkValidation) {
        if ( dateSend.getDate().toString().isEmpty() ) {
            dateSendWorkValidation.setText("Debe llenar este campo");
        } else {
            dateSendWorkValidation.setText("");
        }
    }

    @Override
    public void validateClientWork(JComboBox clientCBox, JLabel clientWorkValidation) {
        if ( clientCBox.getSelectedItem().toString().isEmpty() ) {
            clientWorkValidation.setText("Seleccione un servicio");
        } else {
            clientWorkValidation.setText("");
        }
    }

    @Override
    public void validateIssuesWork(JTextPane issuesTPane, JLabel issuesWorkValidation) {
        if ( issuesTPane.getText().isEmpty() ) {
            issuesWorkValidation.setText("Debe agregar las fallas del vehiculo");
        } else if ( issuesTPane.getText().length() > 255) {
            issuesWorkValidation.setText("El texto debe ser menor a 256 caracteres");
        } else {
            issuesWorkValidation.setText("");
        }
    }
}
