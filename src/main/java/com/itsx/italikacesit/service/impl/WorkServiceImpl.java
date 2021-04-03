package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Work;
import com.itsx.italikacesit.service.WorkService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class WorkServiceImpl implements WorkService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public WorkServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    @Override
    public boolean createWork(Work work) {

        if ( work != null ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            work = entityManager.merge(work);
            entityManager.persist(work);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }

        return false;
    }

    @Override
    public boolean removeWorkByFolio(int folio) {
        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Work work = entityManager.find(Work.class, folio);
            entityManager.remove(work);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateWorkByObject(Work work) {
        int folio = work.getFolio();

        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            work = entityManager.merge(work);
            Work workManaged = entityManager.find(Work.class, folio);
            workManaged = work;

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public Work getWorkByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Work> work = Optional
                .ofNullable(entityManager.find(Work.class, folio));
        entityManager.close();
        return work.get();
    }

    @Override
    public List<Work> getAllWorks() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Work>> workList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Work")
                        .getResultList());
        entityManager.close();
        return workList.get();
    }

    public boolean isDifferentFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Work>> workList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Work")
                        .getResultList()
                );

        if ( !workList.get().stream()
                .anyMatch(x -> x.getFolio() == folio) ) {
            return false;
        }

        entityManager.close();
        return true;
    }
}
