package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Administrator;
import com.itsx.italikacesit.service.AdministratorService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class AdministratoriServiceImpl implements AdministratorService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public AdministratoriServiceImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("aplicacion");
    }

    @Override
    public boolean createAdministrator(Administrator administrator) {
        if (administrator != null) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            administrator = entityManager.merge(administrator);
            entityManager.persist(administrator);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAdministratorByFolio(int folio) {
        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Administrator administrator = entityManager.find(Administrator.class, folio);
            entityManager.remove(administrator);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAdministratorByFolio(Administrator administrator) {
        int folio = administrator.getFolio();

        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            administrator = entityManager.merge(administrator);
            Administrator administratorManaged = entityManager.find(Administrator.class,folio);
            administratorManaged = administrator;

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public Administrator getAdministratorByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Administrator> administrator = Optional.ofNullable(entityManager.find(Administrator.class,folio));
        entityManager.close();
        return administrator.get();
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Administrator>> administratorList = Optional
                .ofNullable(entityManager.createQuery("FROM Administrator").getResultList());

        entityManager.close();
        return administratorList.get();
    }

    public boolean isDifferentFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Administrator>> administratorList = Optional
                .ofNullable(entityManager.createQuery("FROM Administrator").getResultList());

        if (!administratorList.get().stream()
                .anyMatch(x -> x.getFolio().intValue() == folio)) {
            System.out.println("lo dejo pasar");
            return false;
        }

        entityManager.close();
        return true;
    }
}
