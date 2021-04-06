package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Vehicle;
import com.itsx.italikacesit.service.VehicleService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase {@code VehicleServiceImpl} se encarga de la
 * implementacion de la interfaz {@link VehicleService}.
 * Se definen 2 atributos de tipo, {@link EntityManager} y {@link EntityManagerFactory}
 * los cuales ambos son interfaces.
 * <p>
 * El {@code entityManagerFactotry} se utiliza como fabrica de
 * entidades administradas. Una vez que se crea un {@code entityManagerFactory}
 * se crea un {@code entityManager} y se instancia la logica del
 * {@code entityManagerFactory} creado.
 *
 * @author Alexis Vazquez
 * @see com.itsx.italikacesit.service.VehicleService
 * @since   11
 */
public class VehicleServiceImpl implements VehicleService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    /**
     * Crea un <code>entityManagerFactory</code> desde el constructor.
     */
    public VehicleServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    /**
     * Crea un nuevo vehiculo en una transaccion de base de datos.
     * @param vehicle
     * @return true si se crea correctamente el vehiculo y false en
     * caso de tratar de agregar un vehiculo en null.
     */
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

    /**
     * Remueve un vehiculo segun la placa que se pase por parametro.
     * @param plaque
     * @return true si se elimina el vehiculo de forma correcta, y false
     * en caso de paser un folio igual o menor a cero y que la placa no
     * exista en la base de datos.
     */
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

    /**
     * Actualiza un vehiculo por objeto, y se obtiene la placa dentro del
     * proceso.
     * @param vehicle
     * @return true en caso de actualizarce correctamente el vehiculo, y
     * false en caso de que el folio sea menor o igual a cero y que
     * no exista el vehiculo en la base de datos.
     */
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

    /**
     * Se obtiene un vehiculo segun su placa
     * @param plaque
     * @return <code>Vehicle</code> en caso de encontrarse el vehiculo
     * en la base de datos, en caso de apuntar a un null se retorna un
     * Optional.
     */
    @Override
    public Vehicle getVehicleByPlaque(String plaque) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Vehicle> vehicle = Optional
                .ofNullable(entityManager.find(Vehicle.class, plaque));
        entityManager.close();
        return vehicle.get();
    }

    /**
     * Se obtiene una lista de vehiculos.
     * @return List<Vehicle>
     */
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

    /**
     * La funcion de este metodo es verificar si existe un administrador
     * en la base de datos segun su placa.
     * @param plaque
     * @return true en caso de encontrar el vehiculo en la base de datos, y
     * un false en caso de no encontrarlo en la base de datos.
     */
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
