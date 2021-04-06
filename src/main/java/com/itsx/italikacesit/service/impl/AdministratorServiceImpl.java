package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Administrator;
import com.itsx.italikacesit.service.AdministratorService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase {@code AdministratorServiceImpl} se encarga de
 * la implementacion de la interfaz {@link AdministratorService}.
 * Se definen 2 atributos de tipo, {@link EntityManager} y {@link EntityManagerFactory}
 * los cuales ambos son interfaces.
 * <p>
 * El {@code entityManagerFactotry} se utiliza como fabrica de
 * entidades administradas. Una vez que se crea un {@code entityManagerFactory}
 * se crea un {@code entityManager} y se instancia la logica del
 * {@code entityManagerFactory} creado.
 *
 * @author Alexis Vazquez
 * @see com.itsx.italikacesit.service.AdministratorService
 * @since   11
 */
public class AdministratorServiceImpl implements AdministratorService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    /**
     * Crea un <code>entityManagerFactory</code> desde el constructor.
     */
    public AdministratorServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    /**
     * Crea un nuevo administrador en una transaccion de base de datos.
     * @param administrator
     * @return true si se crea correctamente el administrador y false en caso
     * de tratar de agregar un administrador en null.
     */
    @Override
    public boolean createAdministrator(Administrator administrator) {
        if ( administrator != null ) {
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

    /**
     * Remueve un administrador segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el administrador de forma correcta, y false
     * en caso de pasar un folio igual o menor a cero y que el folio no
     * exista en la base de datos.
     */
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

    /**
     * Actualiza un administrador por objeto, y se obtiene el folio dentro del
     * proceso.
     * @param administrator
     * @return true en caso de actualizarce correctamente el administrador,
     * y false en caso de que el folio sea menor o igual a cero y que no
     * exista el administrador en la base de datos.
     */
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

    /**
     * Se obtiene un administrador segun su folio.
     * @param folio
     * @return <code>Administrator</code> en caso de encontrarse el administrador
     * en la base de datos, en caso de apuntar a un null se retorna un optional.
     */
    @Override
    public Administrator getAdministratorByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Administrator> administrator = Optional
                .ofNullable(entityManager.find(Administrator.class,folio));
        entityManager.close();
        return administrator.get();
    }

    /**
     * Se obtiene una lista de administradores.
     * @return List<Administrator>
     */
    @Override
    public List<Administrator> getAllAdministrators() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Administrator>> administratorList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Administrator")
                        .getResultList()
                );

        entityManager.close();
        return administratorList.get();
    }

    /**
     * La funcion de este metodo es verificar si existe un administrador en la
     * base de datos segun su folio.
     * @param folio
     * @return true en caso de encontrar el administrador en la base de datos, y un false
     * en caso de no encontrarlo en la base de datos.
     */
    public boolean isDifferentFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Administrator>> administratorList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Administrator")
                        .getResultList()
                );

        if ( !administratorList.get().stream()
                .anyMatch(x -> x.getFolio().intValue() == folio)) {
            return false;
        }

        entityManager.close();
        return true;
    }
}
