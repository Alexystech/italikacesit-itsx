package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.TypeOfWork;
import com.itsx.italikacesit.service.TypeOfWorkService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * Esta calse {@code TyperOfWorkServiceImpl} se encarga de la
 * implementacion de la interfaz {@link TypeOfWorkService}.
 * Se definen 2 atributos de tipo, {@link EntityManager} y {@link EntityManagerFactory}
 * los cuales ambos son interfaces.
 * <p>
 * El {@code entityManagerFactotry} se utiliza como fabrica de
 * entidades administradas. Una vez que se crea un {@code entityManagerFactory}
 * se crea un {@code entityManager} y se instancia la logica del
 * {@code entityManagerFactory} creado.
 *
 * @author Alexis Vazquez
 * @see com.itsx.italikacesit.service.TypeOfWorkService
 * @since   11
 */
public class TypeOfWorkServiceImpl implements TypeOfWorkService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    /**
     * Crea un <code>entityManagerFactory</code> desde el constructor.
     */
    public TypeOfWorkServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    /**
     * Crea un nuevo tipo de trabajo en una transaccion de base de datos.
     * @param typeOfWork
     * @return true si se crea correctamente el tipo de trabajo y false
     * en caso de tratar de agregar un tipo de trabajo en null.
     */
    @Override
    public boolean createTypeOfWork(TypeOfWork typeOfWork) {
        if ( typeOfWork != null ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            typeOfWork = entityManager.merge(typeOfWork);
            entityManager.persist(typeOfWork);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    /**
     * Remueve un tipo de trabajo segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el tipo de trabajo de forma correcta, y
     * false en caso de pasar un folio igual o menor a cero y que el
     * folio no exista en la base de datos.
     */
    @Override
    public boolean removeTypeOfWorkByFolio(int folio) {
        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            TypeOfWork typeOfWork = entityManager.find(TypeOfWork.class,folio);
            entityManager.remove(typeOfWork);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un tipo de trabajo por objeto, y se obtiene el folio dentro
     * del proceso.
     * @param typeOfWork
     * @return true en caso de actualizarce correctamente el administrador,
     * y false en caso de que el folio sea menor o igual a cero y que
     * no exista el administrador en la base de datos.
     */
    @Override
    public boolean updateTypeOfWorkByFolio(TypeOfWork typeOfWork) {
        int folio = typeOfWork.getFolio();

        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            typeOfWork = entityManager.merge(typeOfWork);
            TypeOfWork typeOfWorkManaged = entityManager.find(TypeOfWork.class, folio);
            typeOfWorkManaged = typeOfWork;

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    /**
     * Se obtiene un tipo de trabajo segun su folio.
     * @param folio
     * @return <code>TypeOfWork</code> en caso de encontrarse el tipo de
     * trabajo en la base de datos, en caso de apuntar a un null se
     * retorna un Optional.
     */
    @Override
    public TypeOfWork getTypeOfWorkByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<TypeOfWork> typeOfWork = Optional
                .ofNullable(entityManager.find(TypeOfWork.class, folio));
        entityManager.close();
        return typeOfWork.get();
    }

    /**
     * Se obtiene una lista de tipos de trabajo.
     * @return List<TypeOfWork>
     */
    @Override
    public List<TypeOfWork> getAllTypeOfWorks() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<TypeOfWork>> typeOfWorkList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM TypeOfWork")
                        .getResultList());
        entityManager.close();
        return typeOfWorkList.get();
    }

    /**
     * La funcion de este metodo es verificar si existe un tipo de
     * trabajo en la base de datos segun su folio.
     * @param folio
     * @return true en caso de encontrar el tipo de trabajo en la base de
     * datos, y un false en caso de no encontrarlo en la base de
     * datos.
     */
    public boolean isDifferentFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<TypeOfWork>> typeOfWorkList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM TypeOfWork")
                        .getResultList()
                );

        if ( !typeOfWorkList.get().stream()
                .anyMatch(x -> x.getFolio() == folio) ) {
            return false;
        }

        entityManager.close();
        return true;
    }
}
