package woowa.lms.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("lms");

    private DB() {

    }

    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

    public static void close() {
        EMF.close();
    }

}
