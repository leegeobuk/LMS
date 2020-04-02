package woowa.lms.back.repository.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.item.Item;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository implements ItemRepository<Book> {

    private final EntityManager em;

    @Override
    public void save(Book book) {
        em.persist(book);
    }

    @Override
    public Item findById(Long id) {
        try {
            return em.createQuery("SELECT i FROM Item i WHERE TREAT(i as Book).item_id = :id", Item.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Item> findByTitle(String title) {
        return em.createQuery("SELECT i FROM Item i WHERE TREAT(i as Book).title = :title", Item.class)
            .setParameter("title", title)
            .getResultList();
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM Item i WHERE type(i) = Book", Item.class)
            .getResultList();
    }
}
