package woowa.lms.back.repository.item;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.search.BookSearchCriteria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//@Repository
@RequiredArgsConstructor
public class CustomItemRepositoryImpl implements CustomItemRepository {

    private final EntityManager em;

    @Override
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
}
