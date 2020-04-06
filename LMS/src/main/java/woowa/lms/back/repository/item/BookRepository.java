package woowa.lms.back.repository.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.search.BookSearchCriteria;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    public void delete(Book book) {
        em.remove(book);
    }

    @Override
    public Item findById(Long id) {
        try {
            return em.createQuery("SELECT i FROM Item i WHERE TREAT(i as Book).id = :id", Item.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Item> search(BookSearchCriteria criteria) {
        String jpql = "SELECT i FROM Item i";
        boolean prevCondition = false;
        if (StringUtils.hasText(criteria.getTitle())) {
            prevCondition = true;
            jpql += " WHERE i.title LIKE :title";
        }
        if (StringUtils.hasText(criteria.getAuthor())) {
            jpql += prevCondition ? " AND" : " WHERE";
            jpql += " i.author LIKE :author";
        }

        TypedQuery<Item> query = em.createQuery(jpql, Item.class);
        if (jpql.contains(":title")) {
            query.setParameter("title", criteria.getTitle());
        }
        if (jpql.contains(":author")) {
            query.setParameter("author", criteria.getAuthor());
        }
        return query.getResultList();
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM Item i WHERE type(i) = Book", Item.class)
            .getResultList();
    }
}
