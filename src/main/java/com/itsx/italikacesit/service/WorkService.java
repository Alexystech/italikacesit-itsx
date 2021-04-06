package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Work;

import java.util.List;

/**
 * Esta interfaz crea una instancia para interactuar con la
 * base de datos, esta satisface los servicios de un CRUD.
 * -linkoffline https://repositorio.iniap.gob.ec/handle/41000/838
 *
 * @author Alexis Vazquez
 * @since   11
 */
public interface WorkService {

    /**
     * Crea un nuevo servicio de trabajo en una transaccion de base de datos.
     * @param work
     * @return true si se crea correctamente el servicio y false en caso
     * de tratar de agregar un servicio de trabajo en null
     */
    boolean createWork(Work work);

    /**
     * Remueve un trabajo segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el trabajo de forma correcta, y false
     * en caso de pasar un folio igual o menor a cero y que el folio
     * no exista en la base de datos.
     */
    boolean removeWorkByFolio(int folio);

    /**
     * Actualiza un trabajo por obeto, y se obtiene el folio dentro del
     * proceso.
     * @param work
     * @return true en caso de actualizarce correctamente el trabajo,
     * y en false en caso de que el folio sea menor o igual a cero y
     * que no exista el trabajo en la base de datos.
     */
    boolean updateWorkByObject(Work work);

    /**
     * Se obtiene un trabajo segun su folio.
     * @param folio
     * @return <code>Work</code> en caso de encontrarse el trabajo
     * en la base de datos, en caso de apuntar a null se retorna
     * un Optional.
     */
    Work getWorkByFolio(int folio);

    /**
     * Se obtiene una lista de trabajos.
     * @return List<Work>
     */
    List<Work> getAllWorks();
}
