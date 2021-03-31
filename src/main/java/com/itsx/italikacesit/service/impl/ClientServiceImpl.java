package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Client;
import com.itsx.italikacesit.service.ClientService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public ClientServiceImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("aplicacion");
    }

    @Override
    public boolean createClient(Client client) {
        if ( client != null ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            client = entityManager.merge(client);
            entityManager.persist(client);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeClientByFolio(int folio) {
        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Client client = entityManager.find(Client.class, folio);
            entityManager.remove(client);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateClientByFolio(Client client) {
        int folio = client.getFolio();

        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            client = entityManager.merge(client);
            Client clientManaged = entityManager.find(Client.class, folio);
            clientManaged = client;

            entityManager.getTransaction().commit();
            entityManager.close();
        }
        return false;
    }

    @Override
    public Client getClientByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Client> client = Optional.ofNullable(entityManager.find(Client.class, folio));
        entityManager.close();
        return client.get();
    }

    @Override
    public List<Client> getAllClients() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Client>> clientList = Optional
                .ofNullable(entityManager.createQuery("FROM Client").getResultList());

        entityManager.close();
        return clientList.get();
    }

    public boolean isDifferentFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Client>> clientList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Administrator")
                        .getResultList()
                );

        if ( !clientList.get().stream()
                .anyMatch(x -> x.getFolio() == folio) ) {
            return false;
        }

        entityManager.close();
        return true;
    }
}
