import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MainClass {

    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {

        entityManagerFactory = Persistence.createEntityManagerFactory("aplicacion");
        entityManager = entityManagerFactory.createEntityManager();

        List administratorList = entityManager.createQuery("FROM Administrator").getResultList();


        System.out.println("hay " + administratorList.size() + " administradores");

    }
}
