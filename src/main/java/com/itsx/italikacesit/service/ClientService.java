package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Client;

import java.util.List;

/**
 * Esta interfaz crea una instancia para interactuar con la
 * base de datos, esta satisface los servicios de un CRUD.
 * -linkoffline https://repositorio.iniap.gob.ec/handle/41000/838
 *
 * @author Alexis Vazquez
 * @since   11
 */
public interface ClientService {

    /**
     * Se crea un nuevo cliente en una transaccion de base de datos.
     * @param client
     * @return true en caso de crearse correctamente el cliente, y false
     * en caso de pasar un cliente null
     */
    boolean createClient(Client client);

    /**
     * Remueve un cliente segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el cliente de forma correcta, y false en caso
     * de pasar un folio igual o menor a cero y que el folio no exista en
     * la base de datos.
     */
    boolean removeClientByFolio(int folio);

    /**
     * Actualiza un cliente por objeto, y se obtiene el folio dentro del
     * proceso.
     * @param client
     * @return true en caso de actualizarce correctamente el cliente y
     * false en caso de que el folio sea menor o igual a cero y que no
     * exista el cliente en la base de datos.
     */
    boolean updateClientByFolio(Client client);

    /**
     * Se obtiene un cliente segun su folio.
     * @param folio
     * @return <code>Client</code> en caso de encontrarse el cliente en la
     * base de datos, en caso de apuntar a un null se retorna un Optional.
     */
    Client getClientByFolio(int folio);

    /**
     * Se obtiene una lista de clientes.
     * @return List<Client>
     */
    List<Client> getAllClients();
}
