package woowa.lms.repository;

import woowa.lms.domain.item.Item;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemRepository {

    private final EntityManager em;

    public ItemRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Item item) {
        em.persist(item);
    }

    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findByName(String name) {
        return em.createQuery("SELECT i FROM ITEM i WHERE name = :name", Item.class)
            .setParameter(":name", name)
            .getResultList();
    }

    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM ITEM i", Item.class).getResultList();
    }
}
