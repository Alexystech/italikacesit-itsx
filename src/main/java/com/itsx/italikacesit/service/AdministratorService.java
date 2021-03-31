package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Administrator;

import java.util.List;

public interface AdministratorService {
    boolean createAdministrator(Administrator administrator);
    boolean removeAdministratorByFolio(int folio);
    boolean updateAdministratorByFolio(Administrator administrator);
    Administrator getAdministratorByFolio(int folio);
    List<Administrator> getAllAdministrators();
}
