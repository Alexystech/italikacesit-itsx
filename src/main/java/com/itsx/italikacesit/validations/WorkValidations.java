package com.itsx.italikacesit.validations;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public interface WorkValidations {
    void validateTypeServiceWork(JComboBox typeServiceCBox, JLabel typeServiceWorkValidation);
    void validateMechanicWork(JComboBox mechanicCBox, JLabel mechanicWorkValidation);
    void validateVehicleWork(JComboBox vehicleCBox, JLabel vehicleWorkValidation);
    void validatePriceWork(JTextField priceServiceField, JLabel priceWorkValidation);
    void validateDateReceiveWork(JDateChooser dateReceive, JLabel dateReceiveWorkValidation);
    void validateDateSendWork(JDateChooser dateSend, JLabel dateSendWorkValidation);
    void validateClientWork(JComboBox clientCBox, JLabel clientWorkValidation);
    void validateIssuesWork(JTextPane issuesTPane, JLabel issuesWorkValidation);
}
