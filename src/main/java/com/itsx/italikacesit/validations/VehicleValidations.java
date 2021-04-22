package com.itsx.italikacesit.validations;

import javax.swing.*;

public interface VehicleValidations {
    void validatePlaqueVehicle(JTextField plaqueVehicleField, JLabel plaqueVehicleValidation);
    void validateBrandVehicle(JTextField brandVehicleField, JLabel brandVehicleValidation);
    void validateModelVehicle(JTextField modelVehicleField, JLabel modelVehicleValidation);
    void validateYearVehicle(JComboBox yearVehicleCBox, JLabel yearVehicleValidation);
}
