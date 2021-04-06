package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Mechanic;

import java.util.List;

/**
 * Esta interfaz crea una instancia para interactuar con la
 * base de datos, esta satisface los servicios de un CRUD.
 * -linkoffline https://repositorio.iniap.gob.ec/handle/41000/838
 *
 * @author Alexis Vazquez
 * @since   11
 */
public interface MechanicService {

    /**
     * Crea un nuevo mecanico en una transaccion de base de datos.
     * @param mechanic
     * @return true si se crea correctamente el mecanico y el false
     * en caso de tratar de agregar un administrador en null.
     */
    boolean createMechanic(Mechanic mechanic);

    /**
     * Remueve un mecanico segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el mecanico de forma correta, y
     * false en casode pasar un folio igual o menor a cero y que el folio
     * no exista en la base dedatos.
     */
    boolean removeMechanicByFolio(int folio);

    /**
     * Actualiza el mecanico por objeto, y se obtiene el folio dentro del
     * proceso.
     * @param mechanic
     * @return true en caso de actualizarce correctamente el administrador,
     * y el false en caso de que el folio sea menor o igual a cero y que no
     * exista el mecanico en la base de datos.
     */
    boolean updateMechanicByFolio(Mechanic mechanic);

    /**
     * Se obtiene un mecanico segun su folio.
     * @param folio
     * @return <code>Mechanic</code> en caso de encontrarse el mecanico
     * en la base de datos, en caso de apuntar a un null se retorna un
     * Optional.
     */
    Mechanic getMechanicByFolio(int folio);

    /**
     * Se obtiene una lista de mecanicos
     * @return List<Mechanic>
     */
    List<Mechanic> getAllMechanics();
}
