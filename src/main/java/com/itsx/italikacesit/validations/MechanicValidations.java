package com.itsx.italikacesit.validations;

import javax.swing.*;

public interface MechanicValidations {
    void validateMechanicName(JTextField nameMechanicField, JLabel nameMechanicValidation);
    void validateMechanicLastName(JTextField lastNameMechanicField, JLabel lastnameMechanicValidation);
    void validateMechanicMotherLastName(JTextField motherLastNameMechanicField, JLabel motherLastNameMechanicValidation);
    void validateMechanicSpeciality(JTextField specialityMechanicField, JLabel specialityMechanicValidation);
    void validateMechanicCellphone(JTextField cellphoneMechanicField, JLabel cellphoneMechanicValidation);
}
