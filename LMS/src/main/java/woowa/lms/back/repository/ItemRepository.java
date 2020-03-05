package woowa.lms.back.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woowa.lms.back.domain.item.Item;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        em.persist(item);
    }

    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findByName(String name) {
        return em.createQuery("SELECT i FROM ITEM i WHERE i.name = :name", Item.class)
            .setParameter(":name", name)
            .getResultList();
    }

    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM ITEM i", Item.class).getResultList();
    }
}
