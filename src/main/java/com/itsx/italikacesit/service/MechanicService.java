package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Mechanic;

import java.util.List;

public interface MechanicService {
    boolean createMechanic(Mechanic mechanic);
    boolean removeMechanicByFolio(int folio);
    boolean updateMechanicByFolio(int folio);
    List<Mechanic> getAllMechanics();
}
