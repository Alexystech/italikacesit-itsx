package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Administrator;

import java.util.List;

/**
 * Esta interfaz crea una instancia para interactuar con la
 * base de datos, esta satisface los servicios de un CRUD.
 * -linkoffline https://repositorio.iniap.gob.ec/handle/41000/838
 *
 * @author Alexis Vazquez
 * @since   11
 */
public interface AdministratorService {

    /**
     * Crea un nuevo administrador en una transaccion de base de datos.
     * @param administrator
     * @return true si se crea correctamente el administrador y false en caso
     * de tratar de agregar un administrador en null.
     */
    boolean createAdministrator(Administrator administrator);

    /**
     * Remueve un administrador segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el administrador de forma correcta, y false
     * en caso de pasar un folio igual o menor a cero y que el folio no
     * exista en la base de datos.
     */
    boolean removeAdministratorByFolio(int folio);

    /**
     * Actualiza un administrador por objeto, y se obtiene el folio dentro del
     * proceso.
     * @param administrator
     * @return true en caso de actualizarce correctamente el administrador,
     * y false en caso de que el folio sea menor o igual a cero y que no
     * exista el administrador en la base de datos.
     */
    boolean updateAdministratorByFolio(Administrator administrator);

    /**
     * Se obtiene un administrador segun su folio.
     * @param folio
     * @return <code>Administrator</code> en caso de encontrarse el administrador
     * en la base de datos, en caso de apuntar a un null se retorna un optional.
     */
    Administrator getAdministratorByFolio(int folio);

    /**
     * Se obtiene una lista de administradores.
     * @return List<Administrator>
     */
    List<Administrator> getAllAdministrators();
}
