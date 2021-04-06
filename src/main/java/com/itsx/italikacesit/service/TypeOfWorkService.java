package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.TypeOfWork;

import java.util.List;

/**
 * Esta interfaz crea una instancia para interactuar con la
 * base de datos, esta satisface los servicios de un CRUD.
 * -linkoffline https://repositorio.iniap.gob.ec/handle/41000/838
 *
 * @author Alexis Vazquez
 * @since   11
 */
public interface TypeOfWorkService {

    /**
     * Crea un nuevo tipo de trabajo en una transaccion de base de datos.
     * @param typeOfWork
     * @return true si se crea correctamente el tipo de trabajo y false
     * en caso de tratar de agregar un tipo de trabajo en null.
     */
    boolean createTypeOfWork(TypeOfWork typeOfWork);

    /**
     * Remueve un tipo de trabajo segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el tipo de trabajo de forma correcta, y
     * false en caso de pasar un folio igual o menor a cero y que el
     * folio no exista en la base de datos.
     */
    boolean removeTypeOfWorkByFolio(int folio);

    /**
     * Actualiza un tipo de trabajo por objeto, y se obtiene el folio dentro
     * del proceso.
     * @param typeOfWork
     * @return true en caso de actualizarce correctamente el administrador,
     * y false en caso de que el folio sea menor o igual a cero y que
     * no exista el administrador en la base de datos.
     */
    boolean updateTypeOfWorkByFolio(TypeOfWork typeOfWork);

    /**
     * Se obtiene un tipo de trabajo segun su folio.
     * @param folio
     * @return <code>TypeOfWork</code> en caso de encontrarse el tipo de
     * trabajo en la base de datos, en caso de apuntar a un null se
     * retorna un Optional.
     */
    TypeOfWork getTypeOfWorkByFolio(int folio);

    /**
     * Se obtiene una lista de tipos de trabajo.
     * @return List<TypeOfWork>
     */
    List<TypeOfWork> getAllTypeOfWorks();
}
