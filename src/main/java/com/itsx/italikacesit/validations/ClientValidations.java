package com.itsx.italikacesit.validations;

import javax.swing.*;

public interface ClientValidations {
    void validateClientName(JTextField nameClientField, JLabel nameCLientValidation);
    void validateClientLastName(JTextField lastNameClientField, JLabel lastNameClientValidation);
    void validateClientMotherLastName(JTextField motherLastNameClientField, JLabel motherLastNameClientValidation);
    void validateClientCellphone(JTextField cellphoneClientField, JLabel cellphoneClientValidation);
}
