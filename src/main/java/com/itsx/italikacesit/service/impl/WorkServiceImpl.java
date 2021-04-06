package com.itsx.italikacesit.service.impl;

import com.itsx.italikacesit.model.Work;
import com.itsx.italikacesit.service.WorkService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase {@code WorkServiceImpl} se encarga de la
 * implementacion de la interfaz {@link WorkService}.
 * Se definen 2 atributos de tipo, {@link EntityManager} y {@link EntityManagerFactory}
 * los cuales ambos son interfaces.
 * <p>
 * El {@code entityManagerFactotry} se utiliza como fabrica de
 * entidades administradas. Una vez que se crea un {@code entityManagerFactory}
 * se crea un {@code entityManager} y se instancia la logica del
 * {@code entityManagerFactory} creado.
 *
 * @author Alexis Vazquez
 * @see com.itsx.italikacesit.service.WorkService
 * @since   11
 */
public class WorkServiceImpl implements WorkService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    /**
     * Crea un <code>entityManagerFactory</code> desde el constructor.
     */
    public WorkServiceImpl() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("aplicacion");
    }

    /**
     * Crea un nuevo servicio de trabajo en una transaccion de base de datos.
     * @param work
     * @return true si se crea correctamente el servicio y false en caso
     * de tratar de agregar un servicio de trabajo en null
     */
    @Override
    public boolean createWork(Work work) {

        if ( work != null ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            work = entityManager.merge(work);
            entityManager.persist(work);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }

        return false;
    }

    /**
     * Remueve un trabajo segun el folio que se pase por parametro.
     * @param folio
     * @return true si se elimina el trabajo de forma correcta, y false
     * en caso de pasar un folio igual o menor a cero y que el folio
     * no exista en la base de datos.
     */
    @Override
    public boolean removeWorkByFolio(int folio) {
        if (folio > 0 && isDifferentFolio(folio)) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Work work = entityManager.find(Work.class, folio);
            entityManager.remove(work);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un trabajo por obeto, y se obtiene el folio dentro del
     * proceso.
     * @param work
     * @return true en caso de actualizarce correctamente el trabajo,
     * y en false en caso de que el folio sea menor o igual a cero y
     * que no exista el trabajo en la base de datos.
     */
    @Override
    public boolean updateWorkByObject(Work work) {
        int folio = work.getFolio();

        if ( folio > 0 && isDifferentFolio(folio) ) {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            work = entityManager.merge(work);
            Work workManaged = entityManager.find(Work.class, folio);
            workManaged = work;

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    /**
     * Se obtiene un trabajo segun su folio.
     * @param folio
     * @return <code>Work</code> en caso de encontrarse el trabajo
     * en la base de datos, en caso de apuntar a null se retorna
     * un Optional.
     */
    @Override
    public Work getWorkByFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<Work> work = Optional
                .ofNullable(entityManager.find(Work.class, folio));
        entityManager.close();
        return work.get();
    }

    /**
     * Se obtiene una lista de trabajos.
     * @return List<Work>
     */
    @Override
    public List<Work> getAllWorks() {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Work>> workList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Work")
                        .getResultList());
        entityManager.close();
        return workList.get();
    }

    /**
     * La funcion de este metodo es verificar si existe un trabajo en la
     * base de datos segun su folio.
     * @param folio
     * @return true en caso de encontrar el trabajo en la base de datos, y
     * un false en caso de encontrarlo en la base de datos.
     */
    public boolean isDifferentFolio(int folio) {
        entityManager = entityManagerFactory.createEntityManager();
        Optional<List<Work>> workList = Optional
                .ofNullable(entityManager
                        .createQuery("FROM Work")
                        .getResultList()
                );

        if ( !workList.get().stream()
                .anyMatch(x -> x.getFolio() == folio) ) {
            return false;
        }

        entityManager.close();
        return true;
    }
}
