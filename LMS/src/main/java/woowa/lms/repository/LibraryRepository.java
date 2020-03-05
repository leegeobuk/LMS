package woowa.lms.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woowa.lms.domain.Library;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LibraryRepository {

    private final EntityManager em;

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
