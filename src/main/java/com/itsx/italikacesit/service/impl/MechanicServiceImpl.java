package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Mechanic;
import com.itsx.italikacesit.service.MechanicService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class MechanicServiceImpl implements MechanicService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public MechanicServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    @Override
    public boolean createMechanic(Mechanic mechanic) {
        if ( mechanic != null ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            mechanic = entityManager.merge(mechanic);
            entityManager.persist(mechanic);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMechanicByFolio(int folio) {
        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Mechanic mechanic = entityManager.find(Mechanic.class, folio);
            entityManager.remove(mechanic);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMechanicByFolio(Mechanic mechanic) {
        int folio = mechanic.getFolio();

        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            mechanic = entityManager.merge(mechanic);
            Mechanic mechanicManaged = entityManager.find(Mechanic.class, folio);
            mechanicManaged = mechanic;

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public List<Mechanic> getAllMechanics() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Mechanic>> mechanicList = Optional
                .ofNullable(entityManager.createQuery("FROM Mechanic").getResultList());

        entityManager.close();
        return mechanicList.get();
    }

    @Override
    public Mechanic getMechanicByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Mechanic> mechanic = Optional
                .ofNullable(entityManager.find(Mechanic.class, folio));
        entityManager.close();
        return mechanic.get();
    }

    public boolean isDifferentFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Mechanic>> mechanicList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Mechanic")
                        .getResultList()
                );

        if ( !mechanicList.get().stream()
                .anyMatch(x -> x.getFolio() == folio) ) {
            return false;
        }

        entityManager.close();
        return true;
    }
}
