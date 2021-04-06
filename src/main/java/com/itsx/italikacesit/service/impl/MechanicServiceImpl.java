package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Mechanic;
import com.itsx.italikacesit.service.MechanicService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * En esta clase {@code MechanichServiceImpl} se encarga de
 * la implementacion de la interfaz {@link MechanicService}.
 * Se definen 2 atributos de tipo, {@link EntityManager} y {@link EntityManagerFactory}
 * los cuales ambos son interfaces.
 * <p>
 * El {@code entityManagerFactotry} se utiliza como fabrica de
 * entidades administradas. Una vez que se crea un {@code entityManagerFactory}
 * se crea un {@code entityManager} y se instancia la logica del
 * {@code entityManagerFactory} creado.
 *
 * @author Alexis Vazquez
 * @see com.itsx.italikacesit.service.MechanicService
 * @since   11
 */
public class MechanicServiceImpl implements MechanicService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    /**
     * Crea un <code>entityManagerFactory</code> desde el constructor.
     */
    public MechanicServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    /**
     * Crea un nuevo mecanico en una transaccion de base de datos.
     * @param mechanic
     * @return true si se crea correctamente el mecanico y el false
     * en caso de tratar de agregar un administrador en null.
     */
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

    /**
     * Remueve un mecanico segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el mecanico de forma correta, y
     * false en casode pasar un folio igual o menor a cero y que el folio
     * no exista en la base dedatos.
     */
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

    /**
     * Actualiza el mecanico por objeto, y se obtiene el folio dentro del
     * proceso.
     * @param mechanic
     * @return true en caso de actualizarce correctamente el administrador,
     * y el false en caso de que el folio sea menor o igual a cero y que no
     * exista el mecanico en la base de datos.
     */
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

    /**
     * Se obtiene una lista de mecanicos
     * @return List<Mechanic>
     */
    @Override
    public List<Mechanic> getAllMechanics() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Mechanic>> mechanicList = Optional
                .ofNullable(entityManager.createQuery("FROM Mechanic").getResultList());

        entityManager.close();
        return mechanicList.get();
    }

    /**
     * Se obtiene un mecanico segun su folio.
     * @param folio
     * @return <code>Mechanic</code> en caso de encontrarse el mecanico
     * en la base de datos, en caso de apuntar a un null se retorna un
     * Optional.
     */
    @Override
    public Mechanic getMechanicByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Mechanic> mechanic = Optional
                .ofNullable(entityManager.find(Mechanic.class, folio));
        entityManager.close();
        return mechanic.get();
    }

    /**
     * La funcion de este metodo es verficar si existe un mecanico en la
     * base de datos segun su folio.
     * @param folio
     * @return true en caso de encontrar el mecanico en la base de datos,
     * y un false en caso de no encontrarlo en la base de datos.
     */
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
