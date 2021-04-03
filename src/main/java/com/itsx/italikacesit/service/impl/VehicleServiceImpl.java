package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Vehicle;
import com.itsx.italikacesit.service.VehicleService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class VehicleServiceImpl implements VehicleService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public VehicleServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    @Override
    public boolean createVehicle(Vehicle vehicle) {

        if ( vehicle != null ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            vehicle = entityManager.merge(vehicle);
            entityManager.persist(vehicle);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }

        return false;
    }

    @Override
    public boolean removeVehicleByPlaque(String plaque) {

        if ( isDifferentPlaque(plaque) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Vehicle vehicle = entityManager.find(Vehicle.class, plaque);
            entityManager.remove(vehicle);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }

        return false;
    }

    @Override
    public boolean updateVehicleByPlaque(Vehicle vehicle) {
        String plaque = vehicle.getPlaque();

        if ( isDifferentPlaque(plaque) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            vehicle = entityManager.merge(vehicle);
            Vehicle vehicleManaged = entityManager.find(Vehicle.class, plaque);
            vehicleManaged = vehicle;

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public Vehicle getVehicleByPlaque(String plaque) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Vehicle> vehicle = Optional
                .ofNullable(entityManager.find(Vehicle.class, plaque));
        entityManager.close();
        return vehicle.get();
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Vehicle>> vehicleList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Vehicle")
                        .getResultList()
                );
        entityManager.close();
        return vehicleList.get();
    }

    public boolean isDifferentPlaque(String plaque) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Vehicle>> vehicleList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Vehicle")
                        .getResultList()
                );

        if ( !vehicleList.get().stream()
                .anyMatch(x -> x.getPlaque().equals(plaque)) ) {
            return false;
        }

        entityManager.close();
        return true;
    }
}
