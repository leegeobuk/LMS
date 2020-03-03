package woowa.lms.repository;

import woowa.lms.db.DB;
import woowa.lms.domain.Library;

import javax.persistence.EntityManager;
import java.util.List;

public class LibraryRepository {

    private final EntityManager em = DB.getEntityManager();

    public void save(Library library) {
        em.persist(library);
    }

    public Library findById(Long id) {
        return em.find(Library.class, id);
    }

    public List<Library> findByName(String name) {
        return em.createQuery("SELECT l FROM LIBRARY l WHERE name = :name", Library.class)
            .setParameter(":name", name)
            .getResultList();
    }

    public List<Library> findAll() {
        return em.createQuery("SELECT l FROM LIBRARY l", Library.class).getResultList();
    }
}
