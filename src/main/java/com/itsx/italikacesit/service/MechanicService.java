package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Mechanic;

import java.util.List;

public interface MechanicService {
    boolean createMechanic(Mechanic mechanic);
    boolean removeMechanicByFolio(int folio);
    boolean updateMechanicByFolio(Mechanic mechanic);
    Mechanic getMechanicByFolio(int folio);
    List<Mechanic> getAllMechanics();
}
