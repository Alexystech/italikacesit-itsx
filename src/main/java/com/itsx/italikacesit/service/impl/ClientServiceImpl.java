package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Client;
import com.itsx.italikacesit.service.ClientService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase {@code ClientServiceImpl} se encarga de la implementacion
 * de la interfaz {@link ClientService}. Se definen 2 atributos de tipo,
 * {@link EntityManager} y {@link EntityManagerFactory}, los cuales
 * ambos son interfaces.
 *
 * El {@code entityManagerFactotry} se utiliza como fabrica de
 * entidades administradas. Una vez que se crea un {@code entityManagerFactory}
 * se crea un {@code entityManager} y se instancia la logica del
 * {@code entityManagerFactory} creado.
 *
 * @author Alexis Vazquez
 * @see com.itsx.italikacesit.service.ClientService
 * @since   11
 */
public class ClientServiceImpl implements ClientService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    /**
     * crea un <code>entityManagerFactory</code> desde el constructor
     */
    public ClientServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    /**
     * Se crea un nuevo cliente en una transaccion de base de datos.
     * @param client
     * @return true en caso de crearse correctamente el cliente, y false
     * en caso de pasar un cliente null
     */
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

    /**
     * Remueve un cliente segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el cliente de forma correcta, y false en caso
     * de pasar un folio igual o menor a cero y que el folio no exista en
     * la base de datos.
     */
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

    /**
     * Actualiza un cliente por objeto, y se obtiene el folio dentro del
     * proceso.
     * @param client
     * @return true en caso de actualizarce correctamente el cliente y
     * false en caso de que el folio sea menor o igual a cero y que no
     * exista el cliente en la base de datos.
     */
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
            return true;
        }
        return false;
    }

    /**
     * Se obtiene un cliente segun su folio.
     * @param folio
     * @return <code>Client</code> en caso de encontrarse el cliente en la
     * base de datos, en caso de apuntar a un null se retorna un Optional.
     */
    @Override
    public Client getClientByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Client> client = Optional
                .ofNullable(entityManager.find(Client.class, folio));
        entityManager.close();
        return client.get();
    }

    /**
     * Se obtiene una lista de clientes.
     * @return List<Client>
     */
    @Override
    public List<Client> getAllClients() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Client>> clientList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Client")
                        .getResultList());
        entityManager.close();
        return clientList.get();
    }

    /**
     * La funcion de este metodo es verificar si existe un cliente
     * en la base de datos segun su folio.
     * @param folio
     * @return true en caso de encontrar el cliente en la base de datos, y
     * un false en caso de no encontrarlo en la base de datos.
     */
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
