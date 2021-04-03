package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.TypeOfWork;
import com.itsx.italikacesit.service.TypeOfWorkService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class TypeOfWorkServiceImpl implements TypeOfWorkService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public TypeOfWorkServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    @Override
    public boolean createTypeOfWork(TypeOfWork typeOfWork) {
        if ( typeOfWork != null ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            typeOfWork = entityManager.merge(typeOfWork);
            entityManager.persist(typeOfWork);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeTypeOfWorkByFolio(int folio) {
        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            TypeOfWork typeOfWork = entityManager.find(TypeOfWork.class,folio);
            entityManager.remove(typeOfWork);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTypeOfWorkByFolio(TypeOfWork typeOfWork) {
        int folio = typeOfWork.getFolio();

        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            typeOfWork = entityManager.merge(typeOfWork);
            TypeOfWork typeOfWorkManaged = entityManager.find(TypeOfWork.class, folio);
            typeOfWorkManaged = typeOfWork;

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public TypeOfWork getTypeOfWorkByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<TypeOfWork> typeOfWork = Optional
                .ofNullable(entityManager.find(TypeOfWork.class, folio));
        entityManager.close();
        return typeOfWork.get();
    }

    @Override
    public List<TypeOfWork> getAllTypeOfWorks() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<TypeOfWork>> typeOfWorkList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM TypeOfWork")
                        .getResultList());
        entityManager.close();
        return typeOfWorkList.get();
    }

    public boolean isDifferentFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<TypeOfWork>> typeOfWorkList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM TypeOfWork")
                        .getResultList()
                );

        if ( !typeOfWorkList.get().stream()
                .anyMatch(x -> x.getFolio() == folio) ) {
            return false;
        }

        entityManager.close();
        return true;
    }
}
