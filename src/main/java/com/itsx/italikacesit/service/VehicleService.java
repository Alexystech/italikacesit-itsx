package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Vehicle;

import java.util.List;

public interface VehicleService {
    boolean createVehicle(Vehicle vehicle);
    boolean removeVehicleByPlaque(String plaque);
    boolean updateVehicleByPlaque(String plaque);
    List<Vehicle> getAllVehicles();
}
