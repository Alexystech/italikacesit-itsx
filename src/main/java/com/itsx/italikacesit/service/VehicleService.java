package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Vehicle;

import java.util.List;

/**
 * Esta interfaz crea una instancia para interactuar con la
 * base de datos, esta satisface los servicios de un CRUD.
 * -linkoffline https://repositorio.iniap.gob.ec/handle/41000/838
 *
 * @author Alexis Vazquez
 * @since   11
 */
public interface VehicleService {

    /**
     * Crea un nuevo vehiculo en una transaccion de base de datos.
     * @param vehicle
     * @return true si se crea correctamente el vehiculo y false en
     * caso de tratar de agregar un vehiculo en null.
     */
    boolean createVehicle(Vehicle vehicle);

    /**
     * Remueve un vehiculo segun la placa que se pase por parametro.
     * @param plaque
     * @return true si se elimina el vehiculo de forma correcta, y false
     * en caso de paser un folio igual o menor a cero y que la placa no
     * exista en la base de datos.
     */
    boolean removeVehicleByPlaque(String plaque);

    /**
     * Actualiza un vehiculo por objeto, y se obtiene la placa dentro del
     * proceso.
     * @param vehicle
     * @return true en caso de actualizarce correctamente el vehiculo, y
     * false en caso de que el folio sea menor o igual a cero y que
     * no exista el vehiculo en la base de datos.
     */
    boolean updateVehicleByPlaque(Vehicle vehicle);

    /**
     * Se obtiene un vehiculo segun su placa
     * @param plaque
     * @return <code>Vehicle</code> en caso de encontrarse el vehiculo
     * en la base de datos, en caso de apuntar a un null se retorna un
     * Optional.
     */
    Vehicle getVehicleByPlaque(String plaque);

    /**
     * Se obtiene una lista de vehiculos.
     * @return List<Vehicle>
     */
    List<Vehicle> getAllVehicles();
}
